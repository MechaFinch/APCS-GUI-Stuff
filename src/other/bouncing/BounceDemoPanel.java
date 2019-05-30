package other.bouncing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import other.bouncing.objects.Collider;
import other.bouncing.objects.RectObj;

/**
 * Contains the bouncing demo itself
 * 
 * @author Alex Pickering
 */
@SuppressWarnings("serial")
public class BounceDemoPanel extends JPanel {
	private ArrayList<Collider> colliders;
	
	private RectObj r;
	
	public BounceDemoPanel(ArrayList<Collider> cols, RectObj r) {
		colliders = cols;
		this.r = r;
		
		setBackground(Color.white);
	}
	
	public void updateObjects(ArrayList<Collider> cols, RectObj r) {
		colliders = cols;
		this.r = r;
	}
	
	@Override
	public void paintComponent(Graphics g1d) {
		super.paintComponent(g1d);
		
		Graphics2D g = (Graphics2D) g1d;
		
		for(Collider c : colliders) {
			c.paint(g);
		}
		
		r.paint(g);
	}
}
