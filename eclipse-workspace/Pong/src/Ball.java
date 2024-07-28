
public class Ball {
		public int width, height, counter;
		public double xPos, yPos;
		private double speed, direction;
	
		
		
		/*
		 * Constructor (Ball(int x, int y, int w, int h)):
		Initializes a new instance of Ball.
		xPos, yPos: Set the initial position of the ball.
		width, height: Set the dimensions of the ball.
		speed: Sets the initial speed of the ball (3 in this case).
		direction: Sets the initial direction of the ball using a random angle between
		 20 and 90 degrees multiplied by a random integer between 0 and 3.
		 * */
		public Ball(int x, int y, int w, int h) {
			xPos =x;
			yPos=y;
			width=w;
			height =h;
			speed=3;
			direction= 20 + 5 * Math.random() + 90 *((int)(Math.random()*4));
			
		}
		
		
		/*
		 * render(int[] pixels) Method:
		Renders (draws) the ball on the screen represented by the pixels array.
		Loops through each pixel of the ball's width and height.
		Computes the actual screen coordinates (xPix, yPix) by adding the ball's position (xPos, yPos) to the current loop indices (x, y).
		Checks if the computed pixel coordinates are within the bounds of the screen (Game.WIDTH and Game.HEIGHT).
		If within bounds, sets the corresponding pixel in the pixels array to white (0xFFFFFF), representing the ball.
		 * */
		
		public void render(int[] pixels) {
			for(int y=0; y<height; y++) {
				int yPix=(int)(y+yPos);
				if(yPix<0 || yPix>= Game.HEIGHT) {
					continue;
				}
				for(int x =0; x<width; x++) {
					int xPix =(int)(x +xPos);
					
					if(xPix < 0 || xPix>= Game.WIDTH) {
						continue;
					}
				pixels[xPix + yPix * Game.WIDTH]=0xFFFFFF;
				
				}
			
			
		}
	}
		
	/*
	 * update(Player player1, Player player2) Method:
	Updates the position and behavior of the ball.
	Updates the xPos and yPos based on the speed and direction of the ball using trigonometric functions (Math.cos and Math.sin).
	Increases the speed of the ball gradually (speed += 0.005).
	Checks if the ball goes out of bounds horizontally (xPos < 0 or xPos + width > Game.WIDTH) and adjusts the direction accordingly.
	Calls checkCollision(Player player) method if counter is 0 to detect collisions with players (player1 and player2).
	Decreases the counter (presumably for some cooldown effect) if collisions have been detected recently.
	Updates the GAMEWINNER and increases the score of player1 or player2 if the ball goes out of bounds vertically (yPos < 0 or yPos + height > Game.HEIGHT).
	 * */
	public void update(Player player1, Player player2) {
		
		xPos+=speed*Math.cos(Math.toRadians(direction));
		yPos+=-speed * Math.sin(Math.toRadians(direction));
		speed+=.005;
		if(xPos<0 || xPos + width> Game.WIDTH) {
			direction=180-direction;
		}
		if(counter==0) {
		checkCollision(player1);
		checkCollision(player2);
		}else {
			counter--;
		}
		
		
		if(yPos<0) {
			Game.GAMEWINNER=1;
			player1.score++;
		}else if(yPos+ height> Game.HEIGHT) {
			Game.GAMEWINNER = 2;
			player2.score++;
		}
	}
	
	
	/*
	 * checkCollision(Player player) Method:
	Checks if the ball collides with a given Player.
	Uses bounds checking to detect if the ball is outside the player's bounds.
	If the ball collides with the player (i.e., if it's not outside any of the player's bounds), it changes the direction of the ball to simulate bouncing (direction = 360 - direction).
	Sets counter to 20, presumably to implement a cooldown period during which further collisions won't be detected immediately.

	 * */
	public void checkCollision(Player player) {
		if(!(xPos+ width< player.xPos || xPos> player.xPos+player.width || yPos + height< player.yPos || yPos>player.yPos +player.height)) {
			 direction=360-direction;
			 counter=20;
		}
		
	}
	public static void main(String args[]) {
		
	}
}
