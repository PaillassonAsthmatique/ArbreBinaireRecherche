package exceptions;

public class NoeudRacineNonSupprimable extends Exception{
	public NoeudRacineNonSupprimable() {
		super("Le noeud racine ne peut pas être supprimé");
	}
}
