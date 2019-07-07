package com.app.org.lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptbily implements Task {
   
	final ReentrantLock lock=new ReentrantLock(true);
	@Override
	public void performTask() {
		try {
			lock.lockInterruptibly();
			if(lock.getQueueLength()==3)
				lock.lock();
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(Thread.currentThread().getName() + ": Lock acquired.");
			System.out.println("Performing task...");
			System.out.println("Hold Count =  " + lock.getHoldCount());
			System.out.println("Waiting Thread" + lock.getQueueLength());
		} finally {
			System.out.println(Thread.currentThread().getName() + ": Lock released.");
             lock.unlock();
			lock.unlock();
			lock.unlock();
			System.out.println("Hold Count Unlock =  " + lock.getHoldCount());

		}
	}

}
