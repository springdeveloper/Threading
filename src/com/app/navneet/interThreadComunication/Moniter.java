package com.app.navneet.interThreadComunication;

public class Moniter extends Thread {
	private Thread t;
	private Thread t1;
     
	public Moniter(Thread t, Thread t1) {
		super();
		this.t = t;
		this.t1 = t1;
	}

	public void run() {
		while (true) {
			try {
				//System.out.println(t.getName() +"   gooooooooooooooooooooooooooo "+t.getState());
				
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
