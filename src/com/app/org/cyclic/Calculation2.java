package com.app.org.cyclic;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Calculation2 extends Thread {
	private volatile  int param2 = 0;

	public void run() {
		try {
			System.out.println("Test Barrier is broken =" + EvaluationBarrier.newBarrier.isBroken());
			param2 = 20 + 20;
			int index = EvaluationBarrier.newBarrier.await(4000, TimeUnit.MILLISECONDS);
			System.out.println("Number of index " + index);

			System.out.println("Number of Parties arrived Barrier  " + EvaluationBarrier.newBarrier.getNumberWaiting());
		} catch (BrokenBarrierException | TimeoutException | InterruptedException e) {
			System.out.println("Calculation 2 erorr Occured = " + e.getLocalizedMessage());
			e.printStackTrace();

		}

	}
	
	public int getParam() {
		return this.param2;
	}
}
