package com.app.org;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Calculate {
	private final Lock lock = new ReentrantLock(true);
	private String name;

	public Calculate(String name) {
		super();
		this.name = name;
	}

	public void calculate(String string) {
		lock.lock();
		try {
			System.out.println(string + " Start calculation = ");
			lock.lock();
			int i = 0;
			Thread.sleep(1000);
			++i;
			i = i + 2;
			System.out.println(string + " completed calculation = " + i);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			lock.unlock();
			lock.unlock();
		}
	}
}
