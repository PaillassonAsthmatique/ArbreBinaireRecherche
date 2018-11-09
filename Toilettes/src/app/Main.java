package app;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
	public static void main(String[] args) {
		
		class Homme implements Runnable
		{
			private Toilettes wc;
			Homme (Toilettes wc)
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
				System.out.println("Nombres d'hommes : " + wc.getNbHomme());
				wc.sortir("homme");
				System.out.println("Nombres d'hommes : " + wc.getNbHomme());
			}
		}
		
		class Femme implements Runnable
		{
			private Toilettes wc;
			Femme (Toilettes wc)
			{
			this.wc=wc;
			}
			public void run()
			{
				wc.entrer("femme");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Nombres de femmes : " + wc.getNbFemme());
				wc.sortir("femme");
			}
		}
		
		Toilettes wc = new Toilettes();
		
		Homme h1 = new Homme(wc);
		Homme h2 = new Homme(wc);
		Homme h3 = new Homme(wc);
		
		Thread th1 = new Thread(h1);
		Thread th2 = new Thread(h2);
		Thread th3 = new Thread(h3);
		
		Femme f1 = new Femme(wc);
		
		Thread tf1 = new Thread(f1);
		th1.start();
		tf1.start();
		th2.start();
		th3.start();
	}	
}
