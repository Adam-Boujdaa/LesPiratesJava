package cases;
import jeu.Joueur;

public abstract class Case {

	private int numeroCase;
	
	public Case(int numeroCase) {
		this.numeroCase = numeroCase;
	}
	
	public void declencherAction(Joueur joueur1, Joueur joueur2) {}
	
	public int getNumeroCase() {
		return numeroCase;
	}
	
	public abstract int getCodeEffet();
}