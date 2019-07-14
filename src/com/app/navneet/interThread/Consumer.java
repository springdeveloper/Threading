package com.app.navneet.interThread;

import java.util.concurrent.LinkedBlockingQueue;

public class Consumer extends Thread {
	LinkedBlockingQueue<String> map;

	public Consumer(LinkedBlockingQueue<String> map) {
		super();
		this.map = map;
	}

	public void run() {
		while (true) {

			synchronized (map) {

				try {
					while (map.isEmpty()) {
						map.wait();
					}
					System.out.println("Consumer" + map.poll());
					if (map.size() == 0) {
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
