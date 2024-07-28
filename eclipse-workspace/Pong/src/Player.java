
public class Player {
	/*
	 * xPos, yPos: These hold the current coordinates of the player.
	width, height: Define the dimensions of the player's graphical representation.
	score: Tracks the player's score.
	speed: Determines how quickly the player moves horizontally.
	 * */
	
	
	public int xPos, yPos, width, height, score;
	protected int speed =4;
	
	
	/*
	* Constructor (Player(int x, int y, int w, int h)):

	  Initializes a new instance of Player.
	   x, y: Initial position of the player.
	   w, h: Width and height of the player.
	   Sets score to 0 initially.
		 * */
	public Player(int x, int y, int w, int h) {
	
		
		xPos=x;
		yPos=y;
		width=w;
		height=h;
		score=0;
	}
	
	/*
	 * Update Method (void update(boolean left, boolean right, Ball ball)):
	Handles player movement based on input.
	left, right: Booleans indicating whether the left or right movement key is pressed.
	ball: A reference to the Ball object, although not used in this method.
	If right is true and moving to the right (xPos + width < Game.WIDTH), increments xPos by speed.
	If left is true and moving to the left (xPos > 0), decrements xPos by speed.
	 * */
	public void update(boolean left, boolean right, Ball ball) {
		
        if (right) {
            if (xPos + width < Game.WIDTH) {
                xPos += speed;
            }
        } else if (left) {
            if (xPos > 0) {
                xPos -= speed;
            }
        }
    }
	
	
	/*
	 * Render Method (void render(int[] pixels)):
	Draws/render the player on the game screen.
	pixels: Array representing the screen pixels.
	Nested loops iterate over the player's width and height.
	Calculates the pixel position (xPix, yPix) relative to the player's position (xPos, yPos).
	Checks if the pixel is within the screen boundaries (if (xPix < 0 || xPix >= Game.WIDTH || yPix < 0 || yPix >= Game.HEIGHT)); skips rendering if not.
	Sets the corresponding pixel in the pixels array to white (0xFFFFFF), representing the player.
	
	 * */
	public void render(int[] pixels) {
		for(int y =0; y< height; y++) {
			int yPix=y+yPos;
			if(yPix<0 || yPix>= Game. HEIGHT) {
				continue;
			}
			for(int x =0; x<width;x++) {
				int xPix= x+ xPos;
				if(xPix<0 || xPix>= Game.WIDTH) {
					continue;
				}
				
				pixels[xPix +yPix*Game.WIDTH]= 0xFFFFFF;
				
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
