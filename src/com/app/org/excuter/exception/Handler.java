package com.app.org.excuter.exception;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public class Handler implements RejectedExecutionHandler{

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

		System.out.println("Rejected Thread ="+r.toString()+"=  ==="+executor.getActiveCount());
	}

}
