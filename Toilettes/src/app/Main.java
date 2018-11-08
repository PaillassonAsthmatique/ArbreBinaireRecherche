package app;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
	public static void main(String[] args) {
		
		class MyRunnable implements Runnable
		{
			private Toilettes wc;
			MyRunnable (Toilettes wc)
			{
			this.wc=wc;
			}
			public void run()
			{
				wc.entrer("homme");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				wc.sortir("homme");
			}
		}
		Toilettes wc = new Toilettes();
		MyRunnable toiletteUnisexe = new MyRunnable(wc);
		Thread tMain = new Thread(toiletteUnisexe);
		tMain.start();
	}	
}
