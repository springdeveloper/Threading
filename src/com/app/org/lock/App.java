package com.app.org.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

	public static void main(String[] args) {
		final ExecutorService service = Executors.newFixedThreadPool(5);

		LockUnlock app1 = new LockUnlock();
		TryLock app2 = new TryLock();
        Task t=new LockInterruptbily();  
		for (int i = 0; i < 5; i++) {
			service.execute(new Worker(app2));
		}
		service.shutdown();
	}

}
