package org.candle.decompiler.test;

public class Switch {

	public void testSwitch() throws Exception {
		
		int val = 1;
		
		switch (val) {
		case 1:
			System.out.println("Case 1.");
		case 2:
			System.out.println("Case 2.");
			break;
		case 3:
			System.out.println("Case 3.");
			break;
		default:
			System.out.println("Default.");
			break;
		}
	}
}