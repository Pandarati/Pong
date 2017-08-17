import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	
	public double xVel, yVel, x, y;
	
	public Ball() {
		this.x = 350;
		this.y = 250;
		this.xVel = 20;
		this.yVel= 3;
	}
	
	/** Draws the Ball
	 * 
	 * @param g
	 */
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval((int)x-20, (int)y-20, 40, 40);
	}

	/** Checks for a collision with the paddle
	 * 
	 * @param p1
	 * @param p2
	 */
	public void checkPaddleCollision(HumanPaddle p1, AIPaddle p2) {
		if(x < 80) {
			if(y >= p1.getY() && y <= p1.getY() + 160) {
				xVel = -xVel;
			}
		}
		if(x >= 1320 ){
			if(y >= p2.getY() && y <= p2.getY() + 160) {
				xVel = -xVel;
			}
		}
	}
	
	/** Controls the balls movement
	 * 
	 */
	public void move() {
		x += xVel;
		y += yVel;
		
		//Set the bounds for Ball Movement
		if(y < 20) {
			yVel = -yVel;
		}
		if(y > 980) {
			yVel = -yVel;
		}
	}
	
	public int getX() {
		return (int)x;
	}
	
	public int getY() {
		return (int)y;
	}

}
