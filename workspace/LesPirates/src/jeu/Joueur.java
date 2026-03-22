package jeu;

public class Joueur {
	public static final int VIE_INITIALE = 5;
	public static final int POSITION_DEPART = 1;
	
	private String nom;
	private int vie;
	private int positionPlateau;
	private Couleur couleurPion;
	
	public Joueur(String nom, Couleur couleurPion) {
		this.nom = nom;
		this.couleurPion = couleurPion;
		this.vie = VIE_INITIALE;
		this.positionPlateau = POSITION_DEPART;
	}

	public void avancer(int nbCases) {
		int res = positionPlateau + nbCases;
		if (res <= Plateau.NB_CASES) {
			positionPlateau = res;
		} else {
			positionPlateau = Plateau.NB_CASES;
		}
	}
	
	public boolean estVivant() {
		return (vie > 0);
	}
	
	public void ajouterVie(int val) {
		vie += val;
	}
	
	public void setPositionPlateau(int val) {
		positionPlateau = val;
	}

	public int getPosition() {return positionPlateau;}
	
	public String getNom() {return nom;}
	
	public int getVie() {return vie;}
	
	public Couleur getCouleurPion() {return couleurPion;}
}