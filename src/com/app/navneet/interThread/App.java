package com.app.navneet.interThread;

import java.util.concurrent.LinkedBlockingQueue;

public class App extends Thread{


	
	
	public static void main(String[] args) {

		
		LinkedBlockingQueue<String> map=new LinkedBlockingQueue<>();
		Producer pr=new Producer(map);
		Consumer cr=new Consumer(map);
		pr.start();
		cr.start();
		
		
	}

}
