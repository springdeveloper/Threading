package com.app.org.lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockUnlock implements Task{
  final ReentrantLock lock=new ReentrantLock(true);
	@Override
	public void performTask() {

		try {
			lock.lock();
			System.out.println("Thread Acquired Lock "+Thread.currentThread().getName());
			System.out.println("Lock Count "+lock.getHoldCount());
			System.out.println("Start Proccessing thread "+Thread.currentThread().getName());
			Thread.sleep(1000);
			System.out.println("Proccessing Completed Thread  "+Thread.currentThread().getName());
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.unlock();
		}
	}

}
