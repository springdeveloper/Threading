package com.app.org.cyclic;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class EvaluationBarrier implements Runnable {

	public static final CyclicBarrier newBarrier = new CyclicBarrier(3);

	public static void main(String[] args) {
		EvaluationBarrier evl = new EvaluationBarrier();
		Thread t = new Thread(evl);
		t.start();

	}

	@Override
	public void run() {
		try {
			System.out.println("Number of parties required to trip bariier " + EvaluationBarrier.newBarrier.getParties());
			Calculation1 cal = new Calculation1();
			Calculation2 cal2 = new Calculation2();
		
			cal.start();
			cal2.start();
			System.out
			.println("Number of parties arrives Barrier = " + EvaluationBarrier.newBarrier.getNumberWaiting());

			try {
				int index=EvaluationBarrier.newBarrier.await();
				System.out.println("Number of index final  " + index);

			} catch (BrokenBarrierException | InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Sum of calculation = " + (cal.getParam() + cal2.getParam()));

			
			EvaluationBarrier.newBarrier.reset();
			Thread cal3 = new Thread(new Calculation1());
			Thread cal4 = new Thread(new Calculation2());
		
			cal3.start();
			cal4.start();
			try {
				int index=EvaluationBarrier.newBarrier.await();
				System.out.println("Number of index final  " + index);

			} catch (BrokenBarrierException | InterruptedException e) {
				e.printStackTrace();
			}
			EvaluationBarrier.newBarrier.reset();
			System.out.println("Sum of calculation = " + (cal.getParam() + cal2.getParam()));

			System.out.println("Barrier was reset SuccessFully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
