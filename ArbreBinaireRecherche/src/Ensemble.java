public class Ensemble {
	int valeur;
	Ensemble filsG, filsD;
	
	public Ensemble(int x, Ensemble gauche, Ensemble droite) {
		this.valeur=x;
		this.filsG=gauche;
		this.filsD=droite;
	}

	public static void main( String[] args )
    {
		Ensemble oui = new Ensemble(20,
				new Ensemble(5, new Ensemble(3, null, null), null), null);
		System.out.println(oui.toString());
    }
}