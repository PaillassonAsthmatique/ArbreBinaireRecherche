package app;

public class Philosophe {

	private boolean[] baguettes = new boolean[] {true, true, true, true, true}; 
	
	private Runnable[] philosophes;
	
	
}

class ThreadPhilosophe implements Runnable{

	private Philosophe table;
	
	public ThreadPhilosophe(Philosophe table) {
		this.table = table;
	}
	
	@Override
	public void run() {
		
	}
}
