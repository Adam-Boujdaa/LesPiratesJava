package cases;

import jeu.Joueur;

public class CaseVolVie extends Case {

	public CaseVolVie(int num) {
		super(num);
	}

	@Override
	public void declencherAction(Joueur joueur1, Joueur joueur2) {
		joueur1.ajouterVie(1);
		joueur2.ajouterVie(-1);
	}

	@Override
	public int getCodeEffet() {
		return 2; 
	}
}