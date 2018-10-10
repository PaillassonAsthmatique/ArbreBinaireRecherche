public class Noeud {
	int valeur;
	Noeud filsG, filsD;
	
	public Noeud(int x, Noeud gauche, Noeud droite) {
		this.valeur=x;
		this.filsG=gauche;
		this.filsD=droite;
	}
}