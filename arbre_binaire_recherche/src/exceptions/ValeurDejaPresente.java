package exceptions;

public class ValeurDejaPresente extends Exception{

	public ValeurDejaPresente() {
		super("La valeur est déjà présente dans l'arbre");
	}
}
