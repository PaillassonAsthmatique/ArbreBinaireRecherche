package exceptions;

public class ValeurDejaPresente extends Exception{

	public ValeurDejaPresente() {
		super("La valeur est d�j� pr�sente dans l'arbre");
	}
}
