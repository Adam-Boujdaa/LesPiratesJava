package pack_case;

import java.security.SecureRandom;
import java.util.Random;

import communs.GenerateurRandom;
import jeu.Joueur;

import communs.GenerateurRandom; 


public class CaseRouletteRusse extends Case {
	
	private GenerateurRandom r;
	
	@Override
	protected void declencherAction(Joueur joueur1,Joueur joueur2) {
		joueur.setPositionPlateau(r.gen(30));
	}
	

}
