package jeu;

public class Joueur {
	private String nom;
	private int vie;
	private int positionPlateau;
	private Couleur couleurPion;
	
	public void avancer(int nbCases) {
		int res = positionPlateau+nbCases;
		if (res<=30) {
			positionPlateau=res;
		}
		else {
			positionPlateau=30;
		}
	}
	
	public Boolean estVivant() {
		return (vie<=0);
	}
	
	public void ajouterVie(int val) {
		vie+=val;
	}
	
	public void setPositionPlateau(int val) {
		positionPlateau=val;
	}

	public int getPosition() {
		return positionPlateau;
	}
}
