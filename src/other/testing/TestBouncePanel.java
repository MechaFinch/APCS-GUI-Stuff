package other.testing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * A panel with a bounding square
 * 
 * @author Alex Pickering
 */
@SuppressWarnings("serial")
public class TestBouncePanel extends JPanel {
	private int x = 100, //top left of the square
				y = 100,
				vel = 10,
				xSize = 10,
				ySize = 10;
	
	private long fps = 10;
	
	private double dir = Math.PI;
	
	/**
	 * b o u n c e
	 */
	public TestBouncePanel() {
		setSize(400, 400);
		setPreferredSize(getSize());
		setBackground(Color.white);
		setOpaque(true);
		
		//update loop
		new Thread(() -> {
			
			while(true) {
				//Update pos
				x += Math.cos(dir) * vel;
				y += Math.sin(dir) * vel;
				
				System.out.printf("(%d, %d)%n", x, y);
				
				//collisions
				if(x < 0) {
					x = 0;
					dir += Math.PI; //TODO: actual angle thing
				} else if(x > (getSize().getWidth() - xSize)) {
					x = (int) getSize().getWidth() - xSize;
					dir -= Math.PI; //TODO: actual angle thing
				}
				
				repaint();
				
				try {
					Thread.sleep(1000 / fps);
				} catch(Exception e) {
				}
			}
		}).start();
	}
	
	@Override
	public void paintComponent(Graphics g1d) {
		super.paintComponent(g1d);
		Graphics2D g = (Graphics2D) g1d;
		
		g.setColor(Color.black);
		g.fillRect(x, y, xSize, ySize);
	}
}
