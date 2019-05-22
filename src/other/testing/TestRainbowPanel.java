package other.testing;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * A panel that cycles through the HSV rainbow
 * 
 * @author Alex Pickering
 */
@SuppressWarnings("serial")
public class TestRainbowPanel extends JPanel {
	
	/**
	 * make it r a i n b o w
	 */
	public TestRainbowPanel() {
		setSize(400, 400);
		setPreferredSize(getSize());
		
		new Thread(() -> {
			float hue = 0;
			
			while(true) {
				setBackground(Color.getHSBColor(hue / 360, 1, 1));
				repaint();
				
				hue = (hue % 360) + 1;
				
				try {Thread.sleep(25);} catch(Exception e) {}
			}
		}).start();
	}
}
