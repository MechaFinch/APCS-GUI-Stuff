package main;

import other.testing.*;

/**
 * Main class to run projects from
 * 
 * @author Alex Pickering
 */
public class APCSGUI {
	public static void main(String[] args) {
		//The interface is here to speed up changes to what we're running
		Runnable rw = new TestWindowOne();
		
		rw.run();
	}
}
