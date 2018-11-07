package app;

import java.util.concurrent.Callable;

import grain_fin.EnsembleGrainFin;
import gros_grain.EnsembleGrosGrain;

public class App {

	public static Long[] grosGrainPerfs = new Long[20];
	
	public static Long[] grainFinPerf = new Long[20];
	
	public static EnsembleGrosGrain arbreGrosGrain;
	
	public static EnsembleGrainFin arbreGrainFin;
	
	public static int CHARGE_TEST = 20000;
	
	public static void main(String[] args) {
		
		Callable<Long> threadEcriture;
		Callable<Long> threadSupression;
		
		for ( int i = 0; i < 20 ; i++) {
			arbreGrosGrain = new EnsembleGrosGrain(-1);	
			
			threadEcriture = new Ecriture<EnsembleGrosGrain>(arbreGrosGrain);
			threadSupression = new Suppression<EnsembleGrosGrain>(arbreGrosGrain);
			
			try {
				grosGrainPerfs[i] = threadEcriture.call();
//				grosGrainPerfs[i] += threadSupression.call();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Performance moyenne gros grain: "+moyenne(grosGrainPerfs));
		
		for ( int i = 0; i < 20 ; i++) {
			arbreGrainFin = new EnsembleGrainFin(-1);	
			
			threadEcriture = new Ecriture<EnsembleGrainFin>(arbreGrainFin);
			threadSupression = new Suppression<EnsembleGrainFin>(arbreGrainFin);
			
			try {
				grainFinPerf[i] = threadEcriture.call();
//				grainFinPerf[i] += threadSupression.call();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Performance moyenne grain fin: "+moyenne(grainFinPerf));
		
	}
	
	
	
	
	public static Long moyenne(Long[] tab) {
		long result = 0;
		
		for ( int i = 0; i < tab.length ; i++) {
			result += (long) tab[i];
		}
		
		return result/tab.length;
	}
}

