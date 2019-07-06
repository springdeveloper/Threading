package com.app.org.countdowanlatch;

import java.util.concurrent.CountDownLatch;

public class ServiceWorker extends Thread {
	private int delay;
	private CountDownLatch countDownLatch;
	private String serviceName;

	public ServiceWorker(int delay, CountDownLatch countDownLatch, String serviceName) {
		super();
		this.delay = delay;
		this.countDownLatch = countDownLatch;
		this.serviceName = serviceName;
	}

	@Override
	public void run() {
		try {
			System.out.println("Service Starting By Worker " + this.serviceName);
			Thread.sleep(delay);
			System.out.println("Service Starting ..................................");
			countDownLatch.countDown();
			System.out.println("Service Started Successfully By Worker " + this.serviceName);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
