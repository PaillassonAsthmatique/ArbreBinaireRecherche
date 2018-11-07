package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class Suppression<T extends Ensemble> implements Callable<Long>{
	
	private T arbre;	
	
	private List<Integer> listeEntier = new ArrayList<>();
	
	private Random random = new Random();
	
	private Long timeStart;
		
	public Suppression(T arbre) {
		this.arbre = arbre;
		
		initialiserListe();
	}
	
	private void initialiserListe() {
		for ( int i = 1; i <= App.CHARGE_TEST; i++) {
			listeEntier.add(i);
		}
	}
	
	@Override
	public Long call() throws Exception {
		
		timeStart = System.currentTimeMillis();
		for ( int i = 0; i < App.CHARGE_TEST; i++ ) {
			int x = random.nextInt(App.CHARGE_TEST);
			
			if ( arbre.contient(x)) {
				arbre.supprimer(x);
			}
		}	
		
		return (System.currentTimeMillis() - timeStart);
	}

}
