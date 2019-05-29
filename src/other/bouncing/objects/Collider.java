package other.bouncing.objects;

import java.awt.Graphics2D;

/**
 * An object that can be collided with by a rectangle
 * 
 * @author Alex Pickering
 */
public interface Collider {
	/**
	 * Determines if the given rectangle is colliding with this
	 * 
	 * @param rect The rectangle to check
	 * @return Whether or not they're colliding
	 */
	boolean isColliding(RectObj rect);
	
	/**
	 * Gets the angle to bounce the box off of <br>
	 * This is used for things like rectangles, which have multiple angles to bounce off of
	 * 
	 * @return An angle, in Radians, to bounce off of
	 */
	double getAngle(RectObj rect);
	
	/**
	 * Displays this object on the screen
	 * 
	 * @param g The Graphics2D to use
	 */
	void paint(Graphics2D g);
}
