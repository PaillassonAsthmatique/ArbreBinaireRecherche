package app;

import exceptions.NoeudRacineNonSupprimable;
import exceptions.ValeurDejaPresente;
import exceptions.ValeurNonTrouve;

public abstract class Ensemble {

	public abstract void inserer(int x) throws ValeurDejaPresente;
	
	public abstract void supprimer(int x) throws NoeudRacineNonSupprimable, ValeurNonTrouve;
	
	public abstract boolean contient(int x);
}
