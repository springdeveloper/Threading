package com.app.navneet.interThreadComunication;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Consumer extends Thread {
	LinkedBlockingQueue<String> map;
	private Lock lock;
	private Condition prCondition;
	private Condition crCondition;
	private Thread prod;
	private Thread cons;

	public void setProd(Thread prod) {
		this.prod = prod;
	}

	public void setCons(Thread cons) {
		this.cons = cons;
	}

	public Consumer(LinkedBlockingQueue<String> map, Lock lock, Condition prCondition, Condition crc) {
		super();
		this.map = map;
		this.lock = lock;
		this.prCondition = prCondition;
		this.crCondition = crc;

	}

	public void run() {
		try {
			while (true) {
				System.out.println("Consumer == " + cons.getState());
				System.out.println(prod.getName()+"===" + cons.getState());
			
				receve();

			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
		}
	}

	public void receve() throws InterruptedException {
		lock.lock();
		while (map.isEmpty())
			this.crCondition.await();

		System.out.println("Consumer" + map.poll());
		if (map.isEmpty())
			prCondition.signalAll();

		lock.unlock();

	}
}
