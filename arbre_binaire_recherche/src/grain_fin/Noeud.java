package grain_fin;

import java.util.concurrent.locks.ReentrantReadWriteLock;

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
	
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

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
	public synchronized int getValeur() {
		return valeur;
	}
	
	public synchronized Noeud getNoeudInferieur() {
		return noeudInferieur;
	}
	
	public void setNoeudInferieur(Noeud noeudInferieur) {
		lock.writeLock().lock();
		this.noeudInferieur = noeudInferieur;
		lock.writeLock().unlock();
	}

	public synchronized Noeud getNoeudSuperieur() {
		return noeudSuperieur;
	}

	public void setNoeudSuperieur(Noeud noeudSuperieur) {
		lock.writeLock().lock();
		this.noeudSuperieur = noeudSuperieur;
		lock.writeLock().unlock();
	} 
}
