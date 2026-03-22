package jeu;

import communs.GenerateurRandom;

public class De {
	private int valeur;
	
	public De() {}
	
	public int lancerDes(int nbDes) {
		valeur = 0; 
		for (int i = 0; i < nbDes; i++) {
			valeur += GenerateurRandom.gen(6);
		}
		return valeur;
	}

	public int getValeur() {
		return valeur;
	}
}