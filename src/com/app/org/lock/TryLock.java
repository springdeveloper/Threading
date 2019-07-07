package com.app.org.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TryLock implements Task {
	final ReentrantLock lock = new ReentrantLock();

	@Override
	public void performTask() {
		Thread t = Thread.currentThread();

		try {
			boolean flag = lock.tryLock(100, TimeUnit.MILLISECONDS);
			if (flag) {
				System.out.println("hiiiiiiiiiiiiii");

				try {
					Thread.sleep(4000);
					System.out.println(Thread.currentThread().getName() + ": Lock acquired.");
					System.out.println("Performing task...");
					System.out.println("Hold Count =  " + lock.getHoldCount());
					System.out.println("Waiting Thread" + lock.getQueueLength());
				} finally {
					System.out.println(Thread.currentThread().getName() + ": Lock released.");

					lock.unlock();
					System.out.println("Hold Count Unlock =  " + lock.getHoldCount());

				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
