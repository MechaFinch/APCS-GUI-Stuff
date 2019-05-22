package other.testing;

import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * A basic frame to test from
 * 
 * @author Alex Pickering
 */
@SuppressWarnings("serial")
public class TestFrameOne extends JFrame {
	
	/**
	 * Set up the frame, but don't show until told
	 */
	public TestFrameOne() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 800);
		setTitle("s u c c ");
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(2, 2));
	}
}
