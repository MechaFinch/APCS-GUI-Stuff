package other.bouncing.objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * A rectangle object that moves and bounces around the screen
 * 
 * @author Alex Pickering
 */
public class RectObj {
	private double x,
				   y,
				   width,
				   height;
	
	private Vector velocity;
	
	private boolean trail;
	
	private ArrayList<Integer> xPoses = new ArrayList<>(),
							   yPoses = new ArrayList<>();
	
	/**
	 * Full Constructor
	 * 
	 * @param x X position
	 * @param y Y position
	 * @param width Width
	 * @param height Height
	 * @param dir Direction (Radians)
	 * @param vel Velocity
	 * @param trail Whether or not to show a trail
	 */
	public RectObj(double x, double y, double width, double height, double dir, double vel, boolean trail) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.trail = trail;
		
		velocity = new Vector(dir, vel, true);
	}
	
	/**
	 * Position/Velocity/Trail Constructor
	 * 
	 * @param x X position
	 * @param y Y position
	 * @param dir Direction (Radians)
	 * @param vel Velocity
	 * @param trail Whether or not to show a trail
	 */
	public RectObj(double x, double y, double dir, double vel, boolean trail) {
		this(x, y, 10, 10, dir, vel, trail);
	}
	
	/**
	 * Position/Velocity Constructor
	 * 
	 * @param x X position
	 * @param y Y position
	 * @param dir Direction (Radians)
	 * @param vel Velocity
	 */
	public RectObj(double x, double y, double dir, double vel) {
		this(x, y, 10, 10, dir, vel, false);
	}
	
	/**
	 * Velocity/Trail Constructor
	 * 
	 * @param dir Direction (Radians)
	 * @param vel Velocity
	 * @param trail Whether or not to have a trail
	 */
	public RectObj(double dir, double vel, boolean trail) {
		this(0, 0, 10, 10, dir, vel, trail);
	}
	
	/**
	 * Velocity Constructor
	 * 
	 * @param dir Direction (Radians)
	 * @param vel Velocity
	 */
	public RectObj(double dir, double vel) {
		this(0, 0, 10, 10, dir, vel, false);
	}
	
	/**
	 * Displays the rectangle
	 * 
	 * @param g Graphics2D object to use
	 */
	public void paint(Graphics2D g) {
		g.setColor(Color.black);
		
		if(trail) {
			xPoses.add((int) (x + (width / 2)));
			yPoses.add((int) (y + (height / 2)));
			
			if(xPoses.size() > 100) {
				xPoses.remove(0);
				yPoses.remove(0);
			}
			
			for(int i = 0; i < xPoses.size() - 1; i++) {
				g.drawLine(xPoses.get(i), yPoses.get(i), xPoses.get(i + 1), yPoses.get(i + 1));
			}
		}
		
		g.fillRect((int) x, (int) y, (int) width, (int) height); 
	}
	
	/**
	 * Sets the X position
	 * 
	 * @param x The new X position
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * Sets the Y position
	 * 
	 * @param y The new Y position
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * Sets the width
	 * 
	 * @param w The new width
	 */
	public void setWidth(double w) {
		width = w;
	}
	
	/**
	 * Sets the height
	 * 
	 * @param h The new height
	 */
	public void setHeight(double h) {
		height = h;
	}
	
	/**
	 * Sets the direction
	 * 
	 * @param d The new direction (in Radians)
	 */
	public void setDirection(double d) {
		velocity.setAngle(d);
	}
	
	/**
	 * Sets the velocity
	 * 
	 * @param v The new velocity
	 */
	public void setVelocity(double v) {
		velocity.setMagnitude(v);
	}
	
	/**
	 * Sets the components of the velocity
	 * 
	 * @param x The X component
	 * @param y The Y component
	 */
	public void setComponents(double x, double y) {
		velocity.setComponents(x, y);
	}
	
	/**
	 * Gets the X position
	 * 
	 * @return The X position
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Gets the X component of the velocity
	 * 
	 * @return The velocity's X component
	 */
	public double getXComponent() {
		return velocity.getX();
	}
	
	/**
	 * Gets they Y position
	 * 
	 * @return The Y position
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * Gets the Y component of the velocity
	 * 
	 * @return The velocity's Y component
	 */
	public double getYComponent() {
		return velocity.getY();
	}
	
	/**
	 * Gets the width
	 * 
	 * @return The width
	 */
	public double getWidth() {
		return width;
	}
	
	/**
	 * Gets the height
	 * 
	 * @return The height
	 */
	public double getHeight() {
		return height;
	}
	
	/**
	 * Gets the direction
	 * 
	 * @return The direction (Radians)
	 */
	public double getDirection() {
		return velocity.getAngle();
	}
	
	/**
	 * Gets the velocity
	 * 
	 * @return The velocity
	 */
	public double getVelocity() {
		return velocity.getMagnitude();
	}
}













