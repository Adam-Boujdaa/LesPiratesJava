package jeu;

import affichage.Affichage;
import affichage.IAffichage; 
import cases.Case;

public class Jeu {
	
	private final int nbJoueurs = 2;
	private final int nbDes = 2;
	
	private final IAffichage affich; 
	private final Joueur[] joueurs;
	private final De des;
	private final Plateau plateau;
	
	private int tour; 
	
	public Jeu() {
		this.tour = 0;
		this.affich = new Affichage();
		this.joueurs = new Joueur[nbJoueurs];
		this.joueurs[0] = new Joueur("Jack Le Borgne", Couleur.ROUGE);
		this.joueurs[1] = new Joueur("Bill Jambe de Bois", Couleur.BLEU);
		this.des = new De();
		this.plateau = new Plateau();
	}
	
	private Joueur getJoueurActuel() {
		return joueurs[tour % nbJoueurs];
	}
	
	private void deplacerJoueur(Joueur joueurActuel, Joueur adversaire) {
		if (joueurActuel.estVivant()) {
			joueurActuel.avancer(des.getValeur());
			
			Case caseArrivee = plateau.getCase(joueurActuel.getPosition());
			caseArrivee.declencherAction(joueurActuel, adversaire);
			
			affich.afficherCase(caseArrivee.getNumeroCase(), caseArrivee.getCodeEffet());
		}
	}
	
	private boolean verifierFinPartie(Joueur joueurActuel, Joueur adversaire) {
		if (joueurActuel.getPosition() >= Plateau.NB_CASES || !adversaire.estVivant()) {
			affich.afficherFinPartie(joueurActuel.getNom());
			return true;
		}
		if (!joueurActuel.estVivant()) {
			affich.afficherFinPartie(adversaire.getNom());
			return true;
		}
		return false;
	}
	
	public void lancerJeu() {
		boolean finPartie = false;
		tour = 0;
		
		while (!finPartie) {
			Joueur joueurActuel = getJoueurActuel();
			Joueur adversaire = joueurs[(tour + 1) % nbJoueurs];
			
			affich.afficherDebutTour(joueurActuel.getNom());
			
			affich.attendreValidation(">>> Appuyez sur entreé pour lancer les dés... "); 
			des.lancerDes(nbDes);
			affich.afficherResultatDe(des.getValeur());
			
			affich.attendreValidation(">>> Appuyez sur entrée pour avancer sur le plateau... ");
			deplacerJoueur(joueurActuel, adversaire);
			
			affich.afficherJoueur(joueurActuel.getNom(), joueurActuel.getCouleurPion().name(), joueurActuel.getVie(), joueurActuel.getPosition());
			affich.afficherJoueur(adversaire.getNom(), adversaire.getCouleurPion().name(), adversaire.getVie(), adversaire.getPosition());
			
			affich.attendreValidation(">>> Appuyez sur une entrée pour passer au tour suivant... ");
			
			finPartie = verifierFinPartie(joueurActuel, adversaire);
			tour++;
		}
	}
}