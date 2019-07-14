package com.app.org.prodcons;

public class App {

	public static void main(String[] args) {
	    int arr[] = {12, 11, 13, 5, 6, 7}; 
          System.out.println(arr.length);
		ProdConsImple pd = new ProdConsImple();
		Producer p = new Producer(pd);
		Consumer c = new Consumer(pd);
		p.start();
		c.start();

	}

}
