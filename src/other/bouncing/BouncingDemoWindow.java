package other.bouncing;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

import other.bouncing.objects.*;

/**
 * Contains a window with the bouncing demo
 * 
 * @author Alex Pickering
 */
public class BouncingDemoWindow implements Runnable {
	RectObj rect;
	
	ArrayList<Collider> colliders = new ArrayList<>();
	
	BounceDemoPanel pan;
	
	Random rand = new Random();
	
	final int fps = 30,
			  accuracyLevel = 1;
	
	final double xGravity = 0,
				 yGravity = 0;
	
	public void run() {
		rect = new RectObj(100, 150, rand.nextDouble() * Math.PI * 2, 10, true);
		
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(506, 529);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Build world
		//Add screen borders
		colliders.add(new Border(0, 500, 500));
		colliders.add(new Border(1, 500, 500));
		colliders.add(new Border(2, 500, 500));
		colliders.add(new Border(3, 500, 500));
		
		//owo things to bounce off of
		colliders.add(new LineCollider(100, 100, 200, 200));
		colliders.add(new LineCollider(200, 200, 100, 300));
		colliders.add(new LineCollider(400, 400, 420, 500));
		colliders.add(new LineCollider(300, 350, 100, 300));
		
		pan = new BounceDemoPanel(colliders, rect);
		
		//Running loop
		new Thread(() -> {
			Collider lastCollider = null;
			
			while(true) {
				//Apply g r a v i t y
				rect.setComponents(rect.getXComponent() + xGravity, rect.getYComponent() + yGravity);
				
				//Update position
				double delX = rect.getVelocity() * Math.cos(rect.getDirection()),
					   delY = rect.getVelocity() * Math.sin(rect.getDirection());
				
				//Increased accuracy
				outer:
				for(int i = 0; i < accuracyLevel; i++) {
					rect.setX(rect.getX() + (delX / accuracyLevel));
					rect.setY(rect.getY() + (delY / accuracyLevel));
					
					//Check for collisions
					for(Collider c : colliders) {
						if(c.isColliding(rect)) {
							//Debug
							System.out.printf("Rect is colliding with %s%n" /*at (%f, %f)%n"*/, c /*, rect.getX(), rect.getY()*/);
							
							//If we're colliding with the same thing as last time, don't bounce
							if(c.equals(lastCollider)) break;
							
							//We found a collision, so now we need to do smaller steps.
							rect.setX(rect.getX() - delX);
							rect.setY(rect.getY() - delY);
							
							double sDelX = Math.cos(rect.getDirection()),
								   sDelY = Math.sin(rect.getDirection());
							
							//Loop over small steps (with velocity 1)
							while(!c.isColliding(rect)) {
								rect.setX(rect.getX() + sDelX);
								rect.setY(rect.getY() + sDelY);
							}
							
							//Bounce
							bounce(rect, c);
							
							//Save the collider
							lastCollider = c;
							
							break outer;
						}
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
		rect.setDirection(Math.atan2(dY - nY, dX - nX));
	}
}















