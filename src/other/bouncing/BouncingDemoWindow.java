package other.bouncing;

import javax.swing.JFrame;

/**
 * Contains a window with the bouncing demo
 * 
 * @author Alex Pickering
 */
public class BouncingDemoWindow implements Runnable {
	public void run() {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setResizable(false);
		frame.add(new BounceDemoPanel());
	}
}
