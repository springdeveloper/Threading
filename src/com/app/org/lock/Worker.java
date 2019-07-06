package com.app.org.lock;

public class Worker implements Runnable {

	Task task;
    
	public Worker(Task task) {
		super();
		this.task = task;
	}

	@Override
	public void run() {

		try {
			this.task.performTask();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
