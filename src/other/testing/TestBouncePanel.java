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
	
	private double dir = Math.PI / 4;
	
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
				y -= Math.sin(dir) * vel;
				
				System.out.printf("(%d, %d)\t%f%n", x, y, dir);
				
				//collisions
				if(x < 0) {
					x = 0;
					dir = reflect((1d / 2d) * Math.PI, dir);
				} else if(x > (getSize().getWidth() - xSize)) {
					x = (int) getSize().getWidth() - xSize;
					dir = reflect((3d / 2d) * Math.PI, dir);
				}
				
				if(y < 0) {
					y = 0;
					dir = reflect(0, dir);
				} else if(y > (getSize().getHeight() - ySize)) {
					y = (int) getSize().getHeight() - ySize;
					dir = reflect(2 * Math.PI, dir);
				}
				
				repaint();
				
				try {
					Thread.sleep(1000 / fps);
				} catch(Exception e) {
				}
			}
		}).start();
	}
	
	/**
	 * Reflect an angle about a line defined by an angle <br>
	 * Use atan2(y2 - y1, x2 - x1) to convert from a line to an angle
	 * 
	 * @param wallAngle The angle in radians of the 'wall'
	 * @param incidentAngle The angle in radians of the thing to reflect
	 * @return The reflected angle in radians
	 */
	private double reflect(double wallAngle, double incidentAngle) {
		//oh boy its linear algebra time
		//r = d - 2(d dot n)n
		
		//Convert the angles into vectors
		double nX = Math.cos(wallAngle - (0.5d * Math.PI)),
			   nY = Math.sin(wallAngle - (0.5d * Math.PI)),
			   dX = Math.cos(incidentAngle),
			   dY = Math.sin(incidentAngle);
		
		//Find 2(d dot n)
		double dotDN = 2 * ((nX * dX) + (nY * dY));
		
		//Scale n to get 2(d dot n)n
		nX *= dotDN;
		nY *= dotDN;
		
		//Find d - n and return it
		return Math.atan2(dY - nY, dX - nX);
	}
	
	@Override
	public void paintComponent(Graphics g1d) {
		super.paintComponent(g1d);
		Graphics2D g = (Graphics2D) g1d;
		
		g.setColor(Color.black);
		g.fillRect(x, y, xSize, ySize);
	}
}
