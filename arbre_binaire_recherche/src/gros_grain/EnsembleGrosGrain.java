package gros_grain;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import exceptions.NoeudRacineNonSupprimable;
import exceptions.ValeurDejaPresente;
import exceptions.ValeurNonTrouve;

import app.Ensemble;

/**
 * Implemente une solution d'arbre binaire en <b>gros grain</b><p>
 * L'arbre ne peut pas contenir deux fois la m�me valeur<p>
 * Le noeud racine ne peut pas �tre supprim�
 * 
 * @author Valentin Dequidt, Cedric Hamel
 *
 */
public class EnsembleGrosGrain extends Ensemble{

	/**
	 * Noeud d'aces � l'arbre
	 */
	private Noeud noeudRacine = null;
	
	private Lock lock = new ReentrantLock ();
	
	/* (non-javadoc)
	 * 
	 * Neutraliser le constructeur par defaut
	 * 
	 */
	@SuppressWarnings("unused")
	private EnsembleGrosGrain() {}
	
	/**
	 * Construit un arbre binaire en donnant a noeud racin la valeur pass� en param�tre
	 * 
	 * @param x : valeur a donner au noeud racine de l'arbre
	 */
	public EnsembleGrosGrain(int x) {
		noeudRacine = new Noeud(x);
	}	
	
	/**
	 * Insere un noeud contenant la valeur x dans l'arbre
	 * 
	 * @param x : valeur du noeud qui sera cree
	 */
	@Override
	public void inserer(int x) throws ValeurDejaPresente{
		lock.lock();
		insererRecursif(x, noeudRacine);
		lock.unlock();
	}
	
	/**
	 * Supprime le noeud contenant la valeur x dans l'arbre<p>
	 * Le noeud racine ne peut pas �tre suppri
	 * @param x : la valeur du noeud a supprimer
	 * @throws NoeudRacineNonSupprimable : quand la valeur que l'on veut supprimer est le noeud racine
	 * @throws ValeurNonTrouve : quand l'arbre ne contient pas la valeur donne
	 */
	@Override
	public void supprimer(int x) throws NoeudRacineNonSupprimable, ValeurNonTrouve{
		lock.lock();
		int valeurRacine = this.noeudRacine.getValeur();	
		if ( x == valeurRacine) {
			throw new NoeudRacineNonSupprimable();
		}else {
			supprimerRecursif(x, noeudRacine);
		}
		lock.unlock();
	}
	
	/**
	 * Verifie si l'arbre a un noeud contenant la valeur passe en paremetre
	 * 
	 * @param x
	 * @return : true si l'arbre contient la valeur, false sinon
	 */
	@Override
	public boolean contient(int x){
		lock.lock();
		boolean result = contientRecursif(x, noeudRacine);
		lock.unlock();
		return result;
	}
	
	/**
	 * 	 
	 * Insere une valeur dans l'arbre binaire en creant un noeud contenant la valeur donne en parametre
	 * 
	 * @param x : valeur du noeud qui sera cree
	 * @param noeud : noeud courant de la recursivite
	 * @throws ValeurDejaPresente : la valeur est deja presente dans l'arbre et ne peut pas etre insere
	 */
	private void insererRecursif(int x, Noeud noeud) throws ValeurDejaPresente{
		
		// si la future valeur est plus petite que la valeur du noeud courant
		if ( noeud.getValeur() > x ) {
			if ( noeud.getNoeudInferieur() != null) {
				// si il y a un d�j� un noeud fils inf�rieur alors on continue la r�cursivit�
				insererRecursif(x, noeud.getNoeudInferieur());
			}else {
				// si il n'y a pas de noeud inferieur fils alors on le cr�er et la m�thode est termin�
				noeud.setNoeudInferieur(new Noeud(x));
			}
		// si la future valeur est plus grande que la valeur du noeud courant
		}else if ( noeud.getValeur() < x ) {
			if ( noeud.getNoeudSuperieur() != null) {
				// si il y a un d�j� un noeud fils sup�rieur alors on continue la r�cursivit�
				insererRecursif(x, noeud.getNoeudSuperieur());
			}else {
				// si il n'y a pas de noeud sup�rieur fils alors on le cr�er et la m�thode est termin�
				noeud.setNoeudSuperieur(new Noeud(x));
			}		
		}else {
			// si la valeur est d�j� pr�sente dans l'arbre alors une exception est lev�
			throw new ValeurDejaPresente();
		}
	}
	
	/**
	 * Supprime le noeud contenant la valeur donnee en parametre
	 * 
	 * @param x : valeur du noeud a supprimer
	 * @param noeud : noeud courant de la recursivite
	 * @throws ValeurNonTrouve : la valeur a supprimer n'a pas ete trouve
	 */
	private void supprimerRecursif(int x, Noeud noeud) throws ValeurNonTrouve{
				
		if ( noeud.getNoeudInferieur() != null && x == noeud.getNoeudInferieur().getValeur()) {
			noeud.setNoeudInferieur(null);
		}else if (noeud.getNoeudSuperieur() != null && x == noeud.getNoeudSuperieur().getValeur()){
			noeud.setNoeudSuperieur(null);
		}
		
		// si la valeur a supprimer est plus petite que la valeur du noeud courant
		if ( noeud.getValeur() > x ) {
			if ( noeud.getNoeudInferieur() != null) {
				// si il y a un d�j� un noeud fils inf�rieur alors on continue la r�cursivit�
				supprimerRecursif(x, noeud.getNoeudInferieur());
			}
		// si la valeur a supprimer est plus grande que la valeur du noeud courant
		}else if ( noeud.getValeur() < x ) {
			if ( noeud.getNoeudSuperieur() != null) {
				// si il y a un d�j� un noeud fils sup�rieur alors on continue la r�cursivit�
				supprimerRecursif(x, noeud.getNoeudSuperieur());
			}
		}else {
			// si la valeur est d�j� pr�sente dans l'arbre alors une exception est lev�
			throw new ValeurNonTrouve(x);
		}
	}
	
	/**
	 * Verifie si l'arbre a un noeud contenant la valeur passe en parametre
	 * 
	 * @param x : la valeur du noeud a verifier
	 * @param noeud : le noeud courant de la recursivite
	 * @return true si l'arbre contient un noeud ayant la valeur x, false sinon
	 */
	private boolean contientRecursif(int x, Noeud noeud) {
		// si le noeud courant contient la valeur, on arr�te la recursivite et retourne vrai
		if ( x == noeud.getValeur() ) {
			return true;
		}else if ( noeud.getNoeudSuperieur() != null && x > noeud.getValeur() ) {
			return contientRecursif(x, noeud.getNoeudSuperieur());
		} else if ( noeud.getNoeudInferieur() != null && x < noeud.getValeur() ) {
			return contientRecursif(x, noeud.getNoeudInferieur());
		}else {
			// si on est arriv� � une feuille et qu'elle ne contient pas la valeur recherch�, alors l'arbre ne contient pas la valeur
			return false;
		}
	}
	
	/*
	 * GETTER - SETTER 
	 */
	
	public Noeud getNoeudRacine() {
		return noeudRacine;
	}

}
