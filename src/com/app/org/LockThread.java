package com.app.org;

public class LockThread extends Thread {
	private Calculate calculate;

	public LockThread(Calculate calculate) {
		super();
		this.calculate = calculate;
	}

	public void run() {
		int i = 0;
		this.calculate.calculate(this.currentThread().getName());

	}

	public static void main(String[] args) {
		Calculate cal = new Calculate("");
		Thread[] thread = new Thread[10];
		for (int i = 0; i < thread.length; i++) {
			thread[i] = new Thread(new LockThread(cal)," thread " + i);
		}
		for (int i = 0; i < 10; i++)
	      { 
	         thread[i].start();
	         thread[i].setPriority(MAX_PRIORITY);

	      }
		
	}

}
