package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

public class Ecriture<T extends Ensemble> implements Callable<Long>{

	private T arbreGrosGrain;	
	
	private List<Integer> listeEntier = new ArrayList<>();
	
	private Random random = new Random();
	
	private long timeStart;
		
	public Ecriture(T arbre) {
		this.arbreGrosGrain = arbre;
		
		initialiserListe();
	}
	
	private void initialiserListe() {
		for ( int i = 1; i <= App.CHARGE_TEST; i++) {
			listeEntier.add(i);
		}
	}

	@Override
	public Long call() throws Exception {
		try {
			timeStart = System.currentTimeMillis();

			while(listeEntier.size() != 0) {
				int x = random.nextInt(listeEntier.size());
				arbreGrosGrain.inserer(listeEntier.get(x));
				listeEntier.remove(Integer.valueOf(listeEntier.get(x)));
			}			
		} catch (Exception e) {
			System.out.println("Exception thread écriture gros grain: "+e.getMessage());
		}
								
		return System.currentTimeMillis() - timeStart;
	}
}
