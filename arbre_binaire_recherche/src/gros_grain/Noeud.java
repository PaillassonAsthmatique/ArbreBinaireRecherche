package gros_grain;

public class Noeud {

	/**
	 * Noeud fils contenant une valeur inferieur a ce noeud
	 */
	private Noeud noeudInferieur = null;
	
	/**
	 * Noeud fils contenant une valeur superieur a ce noeud
	 */
	private Noeud noeudSuperieur = null;
	
	/**
	 * Valeur contenu dans ce noeud
	 */
	private int valeur;

	/*(non-javadoc)
	 * 
	 * Neutralise le constructeur par defaut
	 * 
	 */
	@SuppressWarnings("unused")
	private Noeud() {}
	
	public Noeud(int x) {
		this.valeur = x;
	}
	
	/*
	 * GETTER - SETTER
	 */
	public int getValeur() {
		return valeur;
	}
	
	public Noeud getNoeudInferieur() {
		return noeudInferieur;
	}
	
	public void setNoeudInferieur(Noeud noeudInferieur) {
		this.noeudInferieur = noeudInferieur;
	}

	public Noeud getNoeudSuperieur() {
		return noeudSuperieur;
	}

	public void setNoeudSuperieur(Noeud noeudSuperieur) {
		this.noeudSuperieur = noeudSuperieur;
	} 
	
}
