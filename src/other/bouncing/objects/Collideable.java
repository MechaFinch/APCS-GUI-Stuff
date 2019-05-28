package other.bouncing.objects;

/**
 * An object that can be collided with by a rectangle
 * 
 * @author Alex Pickering
 */
public interface Collideable {
	/**
	 * Determines if the given rectangle is colliding with this
	 * 
	 * @param rect The rectangle to check
	 * @return Whether or not they're colliding
	 */
	boolean isColliding(RectObj rect);
}
