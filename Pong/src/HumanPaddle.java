import java.awt.Color;
import java.awt.Graphics;

public class HumanPaddle implements Paddle{

	double y, yVel;
	boolean upAccel, downAccel;
	int player, x;
	final double GRAVITY = 0.94;
	
	public HumanPaddle(int player) {
		this.upAccel = false;
		this.downAccel = false;
		this.y = 200;
		this.yVel = 0;
		this.player = player;
		
		if(this.player == 1) {
			this.x = 20;
		}
		else {
			this.x = 660;
		}
	}
	
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
		
		//Determine the direction the paddle goes in 
		// TODO Auto-generated method stub
		if(upAccel) {
			yVel -= 2;
		}
		else if(downAccel) {
			yVel += 2;
		}
		//Why can't this just be an else
		else if(!upAccel && !downAccel) {
			yVel *= GRAVITY;
		}
		
		
		//Regulates the Speed of Paddle
		if(yVel >= 10)
			yVel = 10;
		else if(yVel <= -10)
			yVel = -10;
		
		y += yVel;
		
		//Set the bounds
		if(y < 0)
			y = 0;
		if(y > 840){
			y = 840;
		}
	}
	
	/** Adds momentum to the up movement
	 * 
	 *  @param input
	 */
	public void setUpAccel(boolean input) {
		this.upAccel = input;
	}
	
	/** Adds momentum to the down movement
	 * 
	 * 	@param input
	 */
	public void setDownAccel(boolean input) {
		this.downAccel = input;
	}

	@Override
	public int getY() {
		return (int)y;
	}

}
