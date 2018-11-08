package app;

import java.util.concurrent.atomic.AtomicInteger;

public class Toilettes {

	private AtomicInteger nbHomme = new AtomicInteger(0);
	
	private AtomicInteger nbFemme = new AtomicInteger(0);
	
	public void incrementerNbHomme() {
		if ( nbHomme.get() < 3 && nbFemme.get() == 0) {
			nbHomme.incrementAndGet();
		}	
	}
	
	public void incrementerNbFemme() {
		if ( nbFemme.get() < 3 && nbHomme.get() == 0 ) {
			nbFemme.incrementAndGet();
		}
	}
	
	public void decrementernbHomme() {
		if ( nbHomme.get() > 1 ) {
			nbHomme.decrementAndGet();
		}
	}
	
	public void decrementernbFemme() {
		if ( nbFemme.get() > 1 ) {
			nbFemme.decrementAndGet();
		}
	}
	
	public int getNbHomme() {
		return nbHomme.get();
	}
	
	public int getNbFemme() {
		return nbFemme.get();
	}
}
