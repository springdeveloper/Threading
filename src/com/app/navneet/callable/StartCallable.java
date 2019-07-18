package com.app.navneet.callable;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class StartCallable {

	public static void main(String[] args) throws IOException {
		ThreadPoolExecutor 	 service = (ThreadPoolExecutor )Executors.newFixedThreadPool(5);
		service.setRejectedExecutionHandler(new ExceptionHandler());
		Worker task = new Worker("D:\\callabale", "Reader orange");
		Worker task2 = new Worker("D:\\callabale", "Reader orange");
		Worker task3 = new Worker("D:\\callabale", "Reader orange");
		Worker task4 = new Worker("D:\\callabale", "Reader orange");
		Worker task5 = new Worker("D:\\callabale", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		List<Worker> runnableTask = Arrays.asList(task, task2, task3, task4);
//
//		ThreadPoolExecutor customExcuter = new ThreadPoolExecutor(2, 2, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
//		customExcuter.setRejectedExecutionHandler(new ExceptionHandler());
//		try {
//			customExcuter.invokeAll(runnableTask);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		customExcuter.shutdown();
		Future<List<ReadFiles>> uy=	service.submit(task5);
		if(uy.isDone()==false) {
			uy.cancel(false);
		}
		
		Future<List<ReadFiles>> futures= service.submit(task5);
		while(!futures.isDone()) {
            System.out.println("Task is still not done...");
            futures.cancel(true);
            System.out.println("Cancel "+futures.isCancelled());
            try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		
		
		
		List<Future<List<ReadFiles>>> read = null;
		try {
			read = service.invokeAll(runnableTask);
			System.out.println("Service is done " + service.isShutdown());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		read.stream().forEach(it -> {
			try {
				it.cancel(false);
				System.out.println("Task Is Completed " + it.isDone());
				it.get().forEach(its -> {

					System.out.println(its.toString());
				});
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		service.shutdown();

	}

}
