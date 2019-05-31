package other.bouncing.objects;

/**
 * A vector for use with velocities
 * 
 * @author Alex Pickering
 */
public class Vector {
	private double x,
				   y;
	
	/**
	 * Component constructor 
	 * 
	 * @param x The X component
	 * @param y The Y component
	 */
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Angle/Speed constructor
	 * 
	 * @param angle The angle of the vector
	 * @param magnitude The magnitude of the vector 
	 * @param a Whether or not to use the values as angle/magnitude (true) or x/y (false)
	 */
	public Vector(double angle, double magnitude, boolean a) {
		if(a) {
			x = Math.cos(angle) * magnitude;
			y = Math.sin(angle) * magnitude;
		} else {
			x = angle;
			y = magnitude;
		}
	}
	
	/**
	 * Sets the X and Y components of the vector
	 * 
	 * @param x The new X component
	 * @param y The new Y component
	 */
	public void setComponents(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Sets the angle of the vector
	 * 
	 * @param a The new angle
	 */
	public void setAngle(double a) {
		double len = Math.sqrt((x * x) + (y * y));
		x = Math.cos(a) * len;
		y = Math.sin(a) * len;
	}
	
	/**
	 * Sets the magnitude of the vector
	 * 
	 * @param m The new angle
	 */
	public void setMagnitude(double m) {
		double ratio = m / Math.sqrt((x * x) + (y * y));
		x = x * ratio;
		y = y * ratio;
	}
	
	/**
	 * Gets the X component
	 * 
	 * @return X
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Gets the Y component
	 * 
	 * @return Y
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * Gets the magnitude
	 * 
	 * @return Magnitude
	 */
	public double getMagnitude() {
		return Math.sqrt((x * x) + (y * y));
	}
	
	/**
	 * Gets the angle
	 * 
	 * @return Angle
	 */
	public double getAngle() {
		return Math.atan2(y, x);
	}
}
