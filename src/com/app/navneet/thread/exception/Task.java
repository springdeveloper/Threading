package com.app.navneet.thread.exception;

public class Task implements Runnable {
	@Override
	public void run() {
		
		Thread.currentThread().setUncaughtExceptionHandler(new UncaughtExceptionHandler());

		System.out.println(Integer.parseInt("123"));
		System.out.println(Integer.parseInt("234"));
		System.out.println(Integer.parseInt("345"));
		System.out.println(Integer.parseInt("XYZ")); // This will cause NumberFormatException
		System.out.println(Integer.parseInt("456"));
		
	}
	public static void main(String[] args) {

		Thread t=new Thread(new Task());
		t.start();
	}

	

}
