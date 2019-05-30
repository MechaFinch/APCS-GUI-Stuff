package other.bouncing.objects;

import java.awt.Graphics2D;

/**
 * An infinite border, used as the walls on the edges of the screen
 * 
 * @author Alex Pickering
 */
public class Border implements Collider {
	private int direction,
				width,
				height;
	
	/**
	 * Creates a border collider <br>
	 * Direction Values: <br>
	 * <ol start="0">
	 * 	<li>North </li>
	 * 	<li>South </li>
	 * 	<li>East </li>
	 * 	<li>West </li>
	 * </ol>
	 * 
	 * @param dir The direction of this Border
	 * @param w The width of the window
	 * @param h The height of the window
	 */
	public Border(int dir, int w, int h) {
		direction = dir;
		width = w;
		height = h;
	}

	@Override
	public boolean isColliding(RectObj rect) {
		switch(direction) {
			case 0:
				return rect.getY() < 0;
			
			case 1:
				return rect.getY() + rect.getHeight() > height;
			
			case 2:
				return rect.getX() + rect.getWidth() > width;
			
			default:
				return rect.getX() < 0;
		}
	}

	@Override
	public void paint(Graphics2D g) {}

	@Override
	public double getAngle(RectObj rect) {
		switch(direction) {
			case 0:
			case 1:
				return 0;
			
			default:
				return (1d / 2d) * Math.PI;
		}
	}
	
	@Override
	public String toString() {
		switch(direction) {
			case 0:
				return "North Border";
			
			case 1:
				return "South Border";
			
			case 2:
				return "East Border";
			
			default:
				return "West Border";
		}
	}
}
