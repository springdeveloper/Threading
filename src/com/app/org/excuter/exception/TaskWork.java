package com.app.org.excuter.exception;

public class TaskWork implements Runnable {

	private int id;

	public TaskWork(int id) {
		super();
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Task " + id + "  is Start By Thread Pool " + Thread.currentThread().toString());
		try {
			   Thread.sleep(1000);
			} catch (InterruptedException ie) {
			   // Handle the exception, and close resources.
			}
		try {
			if (id == 4) {
				Thread.sleep(3000);
				

			} else {
				Thread.sleep(1000);
			}
		} catch (Exception e) {

		}

		System.out.println("Task " + id + "  is Done By Thread Pool " + Thread.currentThread().toString());

	}

}
