package com.app.navneet.interThread;

import java.util.concurrent.LinkedBlockingQueue;

public class Producer extends Thread {
	LinkedBlockingQueue<String> map;

	public Producer(LinkedBlockingQueue<String> map) {
		super();
		this.map = map;
	}

	public void run() {
		while (true) {

			synchronized (map) {
				try {
					
					while (map.size() > 10) 
						map.wait();
					
					for (int i = 0; i < 10; i++) {
						map.add("Navneet"+i);
						System.out.println("Producing == " + i);

					}
					if(map.size()>9) {
					map.notify();
					Thread.sleep(2000);
					}

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}
}
