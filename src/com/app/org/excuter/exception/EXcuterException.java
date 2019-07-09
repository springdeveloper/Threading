package com.app.org.excuter.exception;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class EXcuterException {

	public static void main(String[] args) {
		ExecutorService executor = new ThreadPoolExecutor(8, 8, 0L, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<Runnable>(15),new Handler());
		for (int i = 0; i < 12; i++) {
			Thread t=new Thread(new TaskWork(i));
			if(i==5) {
				t.interrupt();
				t.setPriority(1);
			}
			executor.execute(t);

		}

		executor.shutdown();
		executor.execute(new TaskWork(22));

	}
}
