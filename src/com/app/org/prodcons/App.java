package com.app.org.prodcons;

public class App {

	public static void main(String[] args) {
		ProdConsImple pd = new ProdConsImple();
		Producer p = new Producer(pd);
		Consumer c = new Consumer(pd);
		p.start();
		c.start();

	}

}
