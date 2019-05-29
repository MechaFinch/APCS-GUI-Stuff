package other.bouncing;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import other.bouncing.objects.*;

/**
 * Contains a window with the bouncing demo
 * 
 * @author Alex Pickering
 */
public class BouncingDemoWindow implements Runnable {
	RectObj rect = new RectObj(100, 100, Math.PI / 2, 10);
	
	ArrayList<Collider> colliders = new ArrayList<>();
	
	JPanel pan;
	
	int fps = 30;
	
	public void run() {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Build world
		//Add screen borders
		colliders.add(new Border(0, frame.getWidth(), frame.getHeight()));
		colliders.add(new Border(1, frame.getWidth(), frame.getHeight()));
		colliders.add(new Border(2, frame.getWidth(), frame.getHeight()));
		colliders.add(new Border(3, frame.getWidth(), frame.getHeight()));
		
		pan = new BounceDemoPanel(colliders, rect);
		
		//Running loop
		new Thread(() -> {
			while(true) {
				//Update position
				rect.setX(rect.getX() + (rect.getVelocity() * Math.cos(rect.getDirection())));
				
				//Check for collisions
				for(Collider c : colliders) {
					if(c.isColliding(rect)) {
						bounce(rect, c);
					}
				}
				
				frame.repaint();
				
				try { Thread.sleep(1000 / fps); } catch(Exception e) {}
			}
		}).start();
		
		frame.add(pan);
	}
	
	private void bounce(RectObj rect, Collider c) {
		
	}
}
