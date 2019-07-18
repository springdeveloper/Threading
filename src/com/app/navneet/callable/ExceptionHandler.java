package com.app.navneet.callable;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class ExceptionHandler implements RejectedExecutionHandler{

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

		System.out.println("Rejected Thread ="+r.toString()+"=  ==="+executor.getActiveCount());
	}

}
