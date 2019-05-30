package other.bouncing.objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 * A collider that has a line
 * 
 * @author Alex Pickering
 */
public class LineCollider implements Collider {
	
	private static final float DEFAULT_THICCNESS = 1.5f;
	
	private int x1, x2, y1, y2;
	
	private float thiccness;
	
	/**
	 * Position Constructor
	 * 
	 * @param x1 First X pos
	 * @param y1 First Y pos
	 * @param x2 Second X pos
	 * @param y2 Second Y pos
	 */
	public LineCollider(int x1, int y1, int x2, int y2) {
		this(x1, y1, x2, y2, DEFAULT_THICCNESS);
	}
	
	/**
	 * Position & Stroke Weight Constructor
	 * 
	 * @param x1 First X pos
	 * @param y1 First Y pos
	 * @param x2 Second X pos
	 * @param y2 Second Y pos
	 * @param thiccness The weight of the line
	 */
	public LineCollider(int x1, int y1, int x2, int y2, float thiccness) {
		this.thiccness = thiccness;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	@Override
	public boolean isColliding(RectObj rect) {
		return false;
	}

	@Override
	public double getAngle(RectObj rect) {
		return Math.atan2(y2 - y1, x2 - x1);
	}

	@Override
	public void paint(Graphics2D g) {
		g.setColor(Color.black);
		g.setStroke(new BasicStroke(thiccness));
		g.drawLine(x1, y1, x2, y2);
	}
	
	@Override
	public String toString() {
		return String.format("Line (%d, %d) - (%d, %d)", x1, y1, x2, y2);
	}
}
