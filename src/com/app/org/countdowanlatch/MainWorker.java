package com.app.org.countdowanlatch;

import java.util.concurrent.CountDownLatch;

public class MainWorker implements Runnable {

	public static final CountDownLatch latch = new CountDownLatch(4);

	public static void main(String[] args) {

		Thread t = new Thread(new MainWorker(),"Main Worker");
		t.start();
	}

	@Override
	public void run() {
		try {

			ServiceWorker service1=new ServiceWorker(4000, MainWorker.latch, "First Service");
			ServiceWorker service2=new ServiceWorker(4000, MainWorker.latch, "Second Service");
			ServiceWorker service3=new ServiceWorker(4000, MainWorker.latch, "Third Service");
			ServiceWorker service4=new ServiceWorker(4000, MainWorker.latch, "Fourth Service");
			service1.start();
			service2.start();
			service3.start();
			service4.start();

			MainWorker.latch.await();
			System.out.println("All Service Up Now Starting Main Service");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
