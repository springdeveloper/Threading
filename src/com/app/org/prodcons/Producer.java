package com.app.org.prodcons;

public class Producer extends Thread

{
	ProdConsImple pd;

	public Producer(ProdConsImple pd) {
		super("Producer");
		this.pd = pd;
	}

	public void run() {
		try {
			while (true) {
				pd.put();
				Thread.sleep(7000);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
