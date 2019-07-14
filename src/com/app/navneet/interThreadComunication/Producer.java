
package com.app.navneet.interThreadComunication;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Producer extends Thread {
	LinkedBlockingQueue<String> map;
	private Lock lock;
	private Condition prCondition;
	private Condition crCondition;
	private Thread cons;
	private Thread prod;

	public void setProd(Thread prod) {
		this.prod = prod;
	}

	public void setCons(Thread cons) {
		this.cons = cons;
	}

	
	public Producer(LinkedBlockingQueue<String> map, Lock lock, Condition prCondition, Condition crCondition) {
		super();
		this.map = map;
		this.lock = lock;
		this.prCondition = prCondition;
		this.crCondition = crCondition;

	}

	public void run() {

		try {
			while (true) {
				System.out.println("Consumer"+"===" + cons.getState());
				System.out.println(Thread.currentThread().getName()+"Producer == " + prod.getState());
				Thread.sleep(1000);
				send();

			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
		}
	}

	public void send() throws InterruptedException {
		lock.lock();
		while (map.size() == 10)
			prCondition.await();

		System.out.println("Producing == " + Thread.currentThread().getState());

		for (int i = 0; i < 10; i++) {
			map.add(Thread.currentThread().getName()+" Navneet" + i);
			//System.out.println(Thread.currentThread().getName() + i);

		}
		if (map.size() == 10) {
			crCondition.signal();
		}

		lock.unlock();

	}
}