package com.app.org.prodcons;

public class Consumer extends Thread {
	ProdConsImple pd;

	public Consumer(ProdConsImple pd) {
		super("Consumer");
		this.pd = pd;
	}

	public void run() {
		try {
			while (true) {

				this.pd.get();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
