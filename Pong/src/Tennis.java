import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tennis extends Applet implements Runnable, KeyListener{
	
	final int WIDTH  = 1400, HEIGHT = 1000;
	Thread thread;
	HumanPaddle p1;
	AIPaddle p2;
	Ball b1;
	
	public void init() {
		this.resize(WIDTH, HEIGHT);
		this.addKeyListener(this);
		
		p1 = new HumanPaddle(1);
		b1 = new Ball();
		p2 = new AIPaddle(2, b1);
		
		thread = new Thread(this);
		thread.start();
		
	}
	
	/**Paints the objects of the game
	 * 
	 */
	public void paint(Graphics g){
		
		//Paints the backdrop
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		//Checks to make sure ball didn't go out of screen
		//Tells when a Game Over
		if(b1.getX() < -20 || b1.getX() > 1380) {
			g.setColor(Color.red);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 100)); 
			g.drawString("Game Over", 500, 500);
		}
		else {
			//Draws all of the objects in the game
			p1.draw(g);
			p2.draw(g);
			b1.draw(g);	
		}
	}
	
	/**Constantly repaints the screen for updates to the user
	 * 
	 */
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			p1.move();
			b1.move();
			p2.move();
			b1.checkPaddleCollision(p1, p2);
			
			//Triggers the update method
			repaint();
			
			try {
				Thread.sleep(10);
			}
			catch(InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setUpAccel(true);
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDownAccel(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP) {
			p1.setUpAccel(false);
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			p1.setDownAccel(false);
		}	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
