package other.testing;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Basic testing and experimentation project
 * 
 * @author Alex Pickering
 */
public class TestWindowOne implements Runnable {
	public void run() {
		JFrame mainFrame = new TestFrameOne();
		mainFrame.setVisible(true);
		
		//upper left quadrant - rainbow colors
		mainFrame.add(new TestRainbowPanel());
		
		//Empty panels to fill the layout
		mainFrame.add(new JPanel());
		mainFrame.add(new JPanel());
		mainFrame.add(new JPanel());
	}
}
