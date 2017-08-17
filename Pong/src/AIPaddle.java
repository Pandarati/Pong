import java.awt.Color;
import java.awt.Graphics;

public class AIPaddle implements Paddle{

	double y, yVel;
	boolean upAccel, downAccel;
	int player, x;
	final double GRAVITY = 0.94;
	Ball b1;
	
	public AIPaddle(int player, Ball b1) {
		this.upAccel = false;
		this.downAccel = false;
		this.y = 200;
		this.yVel = 0;
		this.player = player;
		this.b1 = b1;
		
		if(this.player == 1) {
			this.x = 20;
		}
		else {
			this.x = 1340;
		}
	}
	
	/** Draws the AIPaddle
	 * 
	 */
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.white);
		g.fillRect(x, (int)y, 40, 160);
	}

	/** Controls the movement of the AIPaddle 
	 * 
	 */
	@Override
	public void move() {
		
		//Tracks the postion of the ball
		this.y = b1.getY() - 40;
		
		//Set the bounds
		if(y < 0)
			y = 0;
		if(y > 840){
			y = 840;
		}
	}
	
	/** Adds momentum to the up movement
	 * 
	 * @param input
	 */
	public void setUpAccel(boolean input) {
		this.upAccel = input;
	}
	
	/** Adds momentum to the down movement
	 * 
	 * @param input
	 */
	public void setDownAccel(boolean input) {
		this.downAccel = input;
	}

	@Override
	public int getY() {
		return (int)y;
	}

}
