package com.app.navneet.interThreadComunication;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AppStart {

	public static void main(String[] args) {

		LinkedBlockingQueue<String> map = new LinkedBlockingQueue<>();
		Lock lock = new ReentrantLock();
		Condition prc = lock.newCondition();
		Condition crc = lock.newCondition();

		Producer pr = new Producer(map, lock, prc, crc);
		Producer pr1 = new Producer(map, lock, prc, crc);

		Consumer cr = new Consumer(map, lock, prc, crc);
		pr.setName("Producer ");
		cr.setName("Consumer");
		pr1.setName("Seyyyyyyyyyyyyyyy");

		pr.setProd(pr);
		pr.setCons(cr);
		pr1.setProd(pr);
		pr1.setCons(cr);

		cr.setProd(pr);
		cr.setCons(cr);
		pr.start();
		pr1.start();
		cr.start();

		Moniter m = new Moniter(pr1, cr);
		m.start();
	}

}
