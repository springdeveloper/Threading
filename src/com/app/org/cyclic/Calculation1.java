package com.app.org.cyclic;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Calculation1 extends Thread {
	private  volatile  int param = 1;

	public void run() {
		try {
			System.out.println("Check barrier is Broken " + EvaluationBarrier.newBarrier.isBroken());
			param = param * 2 + 1;
			System.out.println(EvaluationBarrier.newBarrier.getNumberWaiting());
			//Thread.sleep(3000);
			int index = EvaluationBarrier.newBarrier.await(4000, TimeUnit.MILLISECONDS);
            EvaluationBarrier.newBarrier.reset();
            
			System.out.println("Number of index " + index);
			System.out
					.println("Number of parties arrives Barrier = " + EvaluationBarrier.newBarrier.getNumberWaiting());

		} catch (BrokenBarrierException | InterruptedException e) {
			System.out.println("erro in Calculation1 " + e.getLocalizedMessage());
			e.printStackTrace();
		} catch (TimeoutException ex) {
			ex.printStackTrace();
		}
	}
	
	public int getParam() {
		return this.param;
	}
}
