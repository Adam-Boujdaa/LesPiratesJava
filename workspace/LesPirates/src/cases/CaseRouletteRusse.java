package cases;

import communs.GenerateurRandom;
import jeu.Joueur;
import jeu.Plateau;

public class CaseRouletteRusse extends Case {
	
	public CaseRouletteRusse(int num) {
		super(num);
	}

	@Override
	public void declencherAction(Joueur joueur1, Joueur joueur2) {
		joueur1.setPositionPlateau(GenerateurRandom.gen(Plateau.NB_CASES));
	}

	@Override
	public int getCodeEffet() {
		return 1; 
	}
}