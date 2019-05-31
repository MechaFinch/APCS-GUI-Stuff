package other.bouncing.objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class RectangleCollider implements Collider {
	
	private static final Color DEFAULT_FILL_COLOR = Color.darkGray,
							   DEFAULT_EDGE_COLOR = Color.black;
	
	private static final float DEFAULT_STROKE = 2f;
	
	private int x, y, w, h;
	
	private BasicStroke stroke;
	
	private Color fillColor,
				  edgeColor;
	
	/**
	 * Full Constructor
	 * 
	 * @param x Top-left corner X
	 * @param y Top-left corner Y
	 * @param w Width
	 * @param h Height
	 * @param strokeWeight Thiccness of the edges
	 * @param fillColor Color of the interior
	 * @param edgeColor Color of the edges
	 */
	public RectangleCollider(int x, int y, int w, int h, float strokeWeight, Color fillColor, Color edgeColor) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.fillColor = fillColor;
		this.edgeColor = edgeColor;
		
		stroke = new BasicStroke(strokeWeight);
	}
	
	/**
	 * Position, Stroke, & Fill Color Constructor
	 * 
	 * @param x Top-left corner X
	 * @param y Top-left corner Y
	 * @param w Width
	 * @param h Height
	 * @param strokeWeight Thiccness of the edges
	 * @param fillColor Color of the full rectangle
	 */
	public RectangleCollider(int x, int y, int w, int h, float strokeWeight, Color fillColor) {
		this(x, y, w, h, strokeWeight, fillColor, fillColor);
	}
	
	/**
	 * Position & Stroke Constructor
	 * 
	 * @param x Top-left corner X
	 * @param y Top-left corner Y
	 * @param w Width
	 * @param h Height
	 * @param strokeWeight Thiccness of the edges
	 */
	public RectangleCollider(int x, int y, int w, int h, float strokeWeight) {
		this(x, y, w, h, strokeWeight, DEFAULT_FILL_COLOR, DEFAULT_EDGE_COLOR);
	}
	
	/**
	 * Position, Fill Color, & Edge Color Constructor
	 * 
	 * @param x Top-left corner X
	 * @param y Top-left corner Y
	 * @param w Width
	 * @param h Height
	 * @param fillColor Color of the interior
	 * @param edgeColor Color of the edges
	 */
	public RectangleCollider(int x, int y, int w, int h, Color fillColor, Color edgeColor) {
		this(x, y, w, h, DEFAULT_STROKE, fillColor, edgeColor);
	}
	
	/**
	 * Position & Fill Color Constructor
	 * 
	 * @param x Top-left corner X
	 * @param y Top-left corner Y
	 * @param w Width
	 * @param h Height
	 * @param fillColor Color of the full rectangle
	 */
	public RectangleCollider(int x, int y, int w, int h, Color fillColor) {
		this(x, y, w, h, DEFAULT_STROKE, fillColor, fillColor);
	}
	
	/**
	 * Position Constructor
	 * 
	 * @param x Top-left corner X
	 * @param y Top-left corner Y
	 * @param w Width
	 * @param h Height
	 */
	public RectangleCollider(int x, int y, int w, int h) {
		this(x, y, w, h, DEFAULT_STROKE, DEFAULT_FILL_COLOR, DEFAULT_EDGE_COLOR);
	}

	@Override
	public boolean isColliding(RectObj rect) {
		return CollisionUtils.rectRect(x, y, w, h, rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
	}

	@Override
	public double getAngle(RectObj rect) {
		double rx = rect.getX(),
			   ry = rect.getY(),
			   rw = rect.getWidth(),
			   rh = rect.getHeight();
		
		//Find which are intersecting
		boolean leftTop = CollisionUtils.lineLine(x, y, x, y + h, rx, ry, rx + rw, ry),
				leftBottom = CollisionUtils.lineLine(x, y, x, y + h, rx, ry + rh, rx + rw, ry + rh),
				rightTop = CollisionUtils.lineLine(x + w, y, x + w, y + h, rx, ry, rx + rw, ry),
				rightBottom = CollisionUtils.lineLine(x + w, y, x + w, y + h, rx, ry + rh, rx + rw, ry + rh),
				topLeft = CollisionUtils.lineLine(x, y, x + w, y, rx, ry, rx, ry + rh),
				topRight = CollisionUtils.lineLine(x, y, x + w, y, rx + rw, ry, rx + rw, ry + rh),
				bottomLeft = CollisionUtils.lineLine(x, y + h, x + w, y + h, rx, ry, rx, ry + rh),
				bottomRight = CollisionUtils.lineLine(x, y + h, x + w, y + h, rx + rw, ry, rx + rw, ry + rh);
	}

	@Override
	public void paint(Graphics2D g) {
		g.setColor(fillColor);
		g.fillRect(x, y, w, h);
		
		g.setStroke(stroke);
		g.setColor(edgeColor);
		g.drawRect(x, y, w, h);
	}
	
	@Override
	public String toString() {
		return String.format("Rectangle (%d, %d), %dx%d", x, y, w, h);
	}
	
}
