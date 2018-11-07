package exceptions;

public class ValeurNonTrouve extends Exception {
	public ValeurNonTrouve(int x) {
		super("La valeur "+x+" n'a pas été trouvé dans l'arbre");
	}
}
