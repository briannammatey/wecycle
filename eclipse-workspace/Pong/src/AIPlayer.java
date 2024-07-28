
public class AIPlayer extends Player {
	
	
	
	public AIPlayer(int x, int y, int w, int h) {
		
		super(x, y, w, h);
		speed=5;
		// TODO Auto-generated constructor stub
	}
	
	public void update(boolean left, boolean right, Ball ball) {
		 if(Math.abs(yPos- ball.yPos)<100) {
			 if(ball.xPos + ball.width/2 - (xPos + width/2)>10) {
				 right=true;
			 }else {
				 right = false;
			 }
			 
			 if(xPos +width/2 - (ball.xPos+ ball.width/2)>10) {
				 left= true;
			 }else {
				 left = false;
			 }
		 }
		super.update(left, right, ball);
	
	}
	
	
	public static void main(String[] args) {
		
	}
}
