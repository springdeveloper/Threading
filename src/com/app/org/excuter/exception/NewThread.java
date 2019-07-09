package com.app.org.excuter.exception;

import java.util.concurrent.ThreadFactory;

public class NewThread implements ThreadFactory {

	@Override
	public Thread newThread(Runnable r) {

		Thread t = new Thread();
		System.out.println("Factory Create " + Thread.currentThread().getName());
		return t;
	}

}
