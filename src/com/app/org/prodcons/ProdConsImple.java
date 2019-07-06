package com.app.org.prodcons;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProdConsImple {
	private static final Integer CAPICITY = 10;
	private final Queue queue = new LinkedList<>();
	private final Random random = new Random();
	private final Lock lock = new ReentrantLock();
	private final Condition notFull = lock.newCondition();
	private final Condition notEmpty = lock.newCondition();

	public void put() {
		lock.lock();
		try {
			while (queue.size() == CAPICITY) {
				System.out.println(Thread.currentThread().getName() + " : Buffer is full, waiting");
				notEmpty.await();
			}
			Integer number = 23;
			boolean isAdded = queue.offer(number);
			System.out.println("number "+queue.size());
			if (isAdded) {
				System.out.printf("%s added %d into queue %n", Thread .currentThread().getName(), number); 

				System.out.println(Thread.currentThread().getName() + " : Signalling that buffer is no more empty now");

				notFull.signal();
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			lock.unlock();
		}
	}

	public void get() {
		lock.lock();
		try {
			while (queue.isEmpty()) {
				notFull.await();
			}

			Object value = queue.poll();
			if (value != null) {
				System.out.printf("%s consumed %d from queue %n", Thread.currentThread().getName(), value);

				System.out.println(Thread.currentThread().getName() + " : Signalling that buffer may be empty now");

				notEmpty.signal();
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			lock.unlock();
		}
	}

}
