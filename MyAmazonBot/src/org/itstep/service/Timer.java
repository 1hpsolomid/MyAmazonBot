package org.itstep.service;

public class Timer {
	public static void waitSeconds(int seconds) {
		Thread thread = new Thread();
		try {
			thread.sleep(1000*seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
