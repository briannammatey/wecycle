import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Game extends Canvas implements Runnable{
	
	
	/*
	 * WIDTH, HEIGHT, and SCALE define the size and scaling of the gamig window.
	 * title holds the window
	 *GAMEWINNER tracks the current game winner
	 * */
	public static final int WIDTH=400, HEIGHT =300, SCALE= 2;
	private String title= "Pong", fps="";
	public static int GAMEWINNER =0;
	
	
	//running indicates when the game is active
	//between rounds mangaes game state between matches
	private boolean running=false, betweenRounds=true;
	
	
	/*
	 * Graphics and Buffering: image, bufferStrat,
	 *  and pixels handle off-screen rendering to improve performance
	 * */
	private BufferedImage image;
	private BufferStrategy bufferStrat;
	private int[] pixels;
	
	
	/*
	 * Threads and Entities: thread manages the game loop thread. 
	 * player1, player2, and ball represent game entities. 
	 * input handles player input.
	 * */
	private Thread thread;
	private Player player1, player2;
	private Input input;
	private Ball ball;

	
	

	
	/*
	 * Constructor: Sets up the game window (JFrame) with title,
	 *  size, and properties. Adds this canvas to the frame. 
	 * Initializes game components via setUp(). 
	 * Registers KeyListener for user input and starts the game loop with start().
	 * */
	public Game(){
		
		
		JFrame frame= new JFrame(title);//initialize title
		frame.setSize(WIDTH* SCALE, HEIGHT * SCALE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		
		frame.add(this);
		frame.setVisible(true);
		
		setUp();
		
		addKeyListener(input);
		requestFocus();
		start();
		
		
	}
	
	/*
	 * setUp(): Creates an off-screen image (image) for rendering.
	 * v Initializes input for handling keyboard input. 
	 * Creates player1, player2, and ball objects with initial positions and sizes.

	 * 
	 * */
	public void setUp() {
		image =new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels=((DataBufferInt)image.getRaster().getDataBuffer()).getData();
		input=new Input();
		player1= new Player(WIDTH/2 - 32, HEIGHT-46, 64, 16);
		//player2= new Player(WIDTH/2-32, 10, 64, 16);
		player2= new AIPlayer(WIDTH/2-32, 10, 64, 16);
		ball= new Ball(WIDTH/2-10, HEIGHT/2 -10, 20, 20);
	}
	
	
	/*
	 * start(): Sets running to true, creates a new thread (thread) using this runnable (Game),
	 *  and starts the thread. This begins the game loop execution.
	 * */
	public void start() {
		running=true;
		thread = new Thread(this);
		thread.start();
	}
	
	
	
	/*
	 * update(): Updates game logic based on player input and game state. 
	 * Calls update() methods for player1, player2, and ball. 
	 * Restarts the game if VK_SPACE is pressed. 
	 * Sets betweenRounds to true when there's a game winner.
	 * */
	public void update() {
		if(!betweenRounds) {
		player1.update(input.key[KeyEvent.VK_A], input.key[KeyEvent.VK_D], ball);
		player2.update(input.key[KeyEvent.VK_LEFT], input.key[KeyEvent.VK_RIGHT], ball);
		
		ball.update(player1, player2);
		}else if(input.key[KeyEvent.VK_SPACE]) {
			restartGame();
		}
		if(GAMEWINNER!=0) {
			betweenRounds=true;
		}
	}
	
	
	/*
	 * render(): Renders the game to the screen.
	 *  Clears pixels array and updates it with player1, player2, and ball renderings. 
	 *  Draws UI elements such as FPS, scores, and game messages (betweenRounds). 
	 *  Disposes of Graphics object and shows the buffer strategy.
	 * */
	public void render() {
		bufferStrat= this.getBufferStrategy();
		if(bufferStrat==null) {
			this.createBufferStrategy(2);
			return;
			
			}
			
			for(int i=0; i<pixels.length; i++) {
			pixels[i]=0;
			}
			player1.render(pixels);
			player2.render(pixels);
			
			ball.render(pixels);
			
			
			pixels[200+150*WIDTH]=0x00FF00;
			Graphics g= bufferStrat.getDrawGraphics();
			g.drawImage(image, 0, 0, WIDTH*SCALE, HEIGHT*SCALE, null);
			
			g.setColor(Color.YELLOW);
			g.setFont(new Font("Verdana", Font.PLAIN, 10*SCALE) );
			g.drawString(fps, 10, 30);
			
			g.setFont(new Font("Verdana", Font.PLAIN, 9*SCALE));
			g.setColor(Color.WHITE);
			g.drawString("Player 1: " +player1.score+ "    Player 2: " + player2.score, HEIGHT, GAMEWINNER);
			
			if(betweenRounds) {
				if(GAMEWINNER ==0) {
					g.drawString("Press SPACE to start", (WIDTH/2 -45) * SCALE , (HEIGHT/2-20)*SCALE);
				}else if(GAMEWINNER==1){
					g.drawString("Player 1 Wins Press SPACE to play again", (WIDTH/2 -85)*SCALE, (HEIGHT/2 -20) * SCALE);
				}else if(GAMEWINNER==2){
					g.drawString("Player 2 Wins Press SPACE to play again", (WIDTH/2 -85)*SCALE, (HEIGHT/2 -20) * SCALE);
			}
			
			
			}
			g.dispose();
			bufferStrat.show();
			
	}
	
	
	
	
	public void run() {
		/*run(): Implements the game loop. 
		 * Tracks time (delta) to regulate updates and renders per second. 
		 * Calls update() and render() methods. Updates FPS and UPS (updates per second). 
		 * Exits the game when running is set to false.
		 */
		int frames=0, updates=0;
		long previousTime = System.nanoTime();
		long timer= System.currentTimeMillis();
		double delta =0;
		
		
		while(running) {
			long currentTime=System.nanoTime();
			delta+=(currentTime-previousTime)/(1000000000.0/60.0);
			previousTime=currentTime;
			if(delta>=1) {
				update();
				updates++;
				delta--;
			}
				render();
				frames++;
				
				while(System.currentTimeMillis()- timer>1000) {
					timer+=1000;
					fps= frames + " FPS | "+ updates + " UPS";
					frames=0;
					updates=0;
				}
			
		}
		
		System.exit(0);
	}
	

	public void restartGame() {
		
		/*
		 * restartGame(): Resets game state for a new round. 
		 * Resets betweenRounds and GAMEWINNER. 
		 * Resets player positions and creates a new ball.
		 * */
		betweenRounds=false;
		GAMEWINNER=0;
		player1.xPos=WIDTH/2 - 32;
		player2.xPos= WIDTH/2 - 32;
		ball = new Ball(WIDTH/2-10, HEIGHT/2-10, 20, 20);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Game();
		
		
		
	}

}
