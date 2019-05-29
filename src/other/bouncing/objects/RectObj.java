package other.bouncing.objects;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 * A rectangle object that moves and bounces around the screen
 * 
 * @author Alex Pickering
 */
public class RectObj {
	private double x,
				   y,
				   width,
				   height,
				   dir,
				   vel;
	
	/**
	 * Full Constructor
	 * 
	 * @param x X position
	 * @param y Y position
	 * @param width Width
	 * @param height Height
	 * @param dir Direction (Radians)
	 * @param vel Velocity
	 */
	public RectObj(double x, double y, double width, double height, double dir, double vel) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.dir = dir;
		this.vel = vel;
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
		this(x, y, 10, 10, dir, vel);
	}
	
	public void paint(Graphics2D g) {
		g.setColor(Color.black);
		g.fillRect((int) x, (int) y, (int) width, (int) height); 
	}
	
	/**
	 * Velocity Constructor
	 * 
	 * @param dir Direction (Radians)
	 * @param vel Velocity
	 */
	public RectObj(double dir, double vel) {
		this(0, 0, 10, 10, dir, vel);
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
		dir = d;
	}
	
	/**
	 * Sets the velocity
	 * 
	 * @param v The new velocity
	 */
	public void setVelocity(double v) {
		vel = v;
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
	 * Gets they Y position
	 * 
	 * @return The Y position
	 */
	public double getY() {
		return y;
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
		return dir;
	}
	
	/**
	 * Gets the velocity
	 * 
	 * @return The velocity
	 */
	public double getVelocity() {
		return vel;
	}
}













