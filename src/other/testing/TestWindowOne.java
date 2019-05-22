package other.testing;

import javax.swing.JPanel;

/**
 * Basic testing and experimentation project
 * 
 * @author Alex Pickering
 */
public class TestWindowOne implements Runnable {
	public void run() {
		TestFrameOne mainFrame = new TestFrameOne();
		mainFrame.setVisible(true);
		
		//upper left quadrant - rainbow colors
		mainFrame.add(new TestRainbowPanel());
		
		//Upper rigt - bouncing square
		mainFrame.add(new TestBouncePanel());
		
		//Empty panels to fill the layout
		mainFrame.add(new JPanel());
		mainFrame.add(new JPanel());
	}
}
