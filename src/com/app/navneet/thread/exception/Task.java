package com.app.navneet.thread.exception;

public class Task implements Runnable {
	private String ids;
	private static int question = 15;

	private static ThreadLocal gfg = new ThreadLocal() {
		protected Object initialValue() {
			return new Integer(question--);
		}
	};

	public Task(String ids) {
		super();
		this.ids = ids;
	}

	@Override
	public void run() {
		while (true) {
			Thread.currentThread().setUncaughtExceptionHandler(new UncaughtExceptionHandler());

			System.out.println(Integer.parseInt("123"));
			System.out.println(Integer.parseInt("234"));
			System.out.println(Integer.parseInt("345"));
			// System.out.println(Integer.parseInt("XYZ")); // This will cause
			// NumberFormatException
			System.out.println(Integer.parseInt("456"));
			System.out.println("name  " + Thread.currentThread().getName() + "--------" + gfg.get());
		}
	}

	public static void main(String[] args) {

		Thread t = new Thread(new Task("a"), "AA");
		Thread t1 = new Thread(new Task("b"), "BB");

		t.start();
		t1.start();
	}

}
