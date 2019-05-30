package other.bouncing;

import java.util.ArrayList;

import javax.swing.JFrame;

import other.bouncing.objects.*;

/**
 * Contains a window with the bouncing demo
 * 
 * @author Alex Pickering
 */
public class BouncingDemoWindow implements Runnable {
	RectObj rect = new RectObj(100, 100, (1d / 2d) * Math.PI, 10);
	
	ArrayList<Collider> colliders = new ArrayList<>();
	
	BounceDemoPanel pan;
	
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
		
		//owo things to bounce off of
		colliders.add(new LineCollider(100, 100, 200, 200));
		
		pan = new BounceDemoPanel(colliders, rect);
		
		//Running loop
		new Thread(() -> {
			while(true) {
				//Update position
				rect.setX(rect.getX() + (rect.getVelocity() * Math.cos(rect.getDirection())));
				rect.setY(rect.getY() + (rect.getVelocity() * Math.sin(rect.getDirection())));
				
				//Check for collisions
				for(Collider c : colliders) {
					if(c.isColliding(rect)) {
						//Undo the movement
						rect.setX(rect.getX() - (rect.getVelocity() * Math.cos(rect.getDirection())));
						rect.setY(rect.getY() - (rect.getVelocity() * Math.sin(rect.getDirection())));
						
						bounce(rect, c);
						System.out.printf("Rect is colliding with %s%n", c);
					}
				}
				
				pan.updateObjects(colliders, rect);
				frame.repaint();
				
				try { Thread.sleep(1000 / fps); } catch(Exception e) {}
			}
		}).start();
		
		frame.add(pan);
	}
	
	private void bounce(RectObj rect, Collider c) {
		/*
		 * Assemble vectors for them linear algebras
		 * d = incident vector
		 * n = normal vector
		 * reflected = d - 2(d dot n) * n
		 */
		
		//Assemble components and apply transformation
		double nX = Math.cos(c.getAngle(rect) - (0.5d * Math.PI)),
			   nY = Math.sin(c.getAngle(rect) - (0.5d * Math.PI)),
			   dX = Math.cos(rect.getDirection()),
			   dY = Math.sin(rect.getDirection()),
			   dotDN2 = 2 * ((nX * dX) + (nY * dY));
		
		//2(d dot n) * n
		nX *= dotDN2;
		nY *= dotDN2;
		
		//Set the angle after finishing the transformation
		System.out.printf("%f before, ", rect.getDirection());
		rect.setDirection(Math.atan2(dY - nY, dX - nX));
		System.out.printf("%f after%n", rect.getDirection());
	}
}















