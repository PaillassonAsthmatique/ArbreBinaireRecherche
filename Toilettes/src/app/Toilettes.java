package app;

import java.util.concurrent.atomic.AtomicInteger;

public class Toilettes {

	private AtomicInteger nbHomme = new AtomicInteger(0);
	private AtomicInteger nbFemme = new AtomicInteger(0);
	
	public void entrer(String sexe) {
		switch(sexe) {
		case "homme" :
			incrementerNbHomme();
			break;
		case "femme" :
			incrementerNbFemme();
			break;
		}	
	}
	
	public void sortir(String sexe) {
		switch(sexe) {
		case "homme" :
			decrementerNbHomme();
			break;
		case "femme" :
			decrementerNbFemme();
			break;
		}	
	}
	
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
	
	public void decrementerNbHomme() {
		if ( nbHomme.get() >= 1 ) {
			nbHomme.decrementAndGet();
		}
	}
	
	public void decrementerNbFemme() {
		if ( nbFemme.get() >= 1 ) {
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
