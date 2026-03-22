package affichage;

public interface IAffichage {

	// !! To CHANGER : UTILISER QUE DES TYPES PRIMITIFS !
	
	void afficherDebutTour(String nomJoueurActuel);
	void afficherResultatDe(int valeurDe);
	void afficherJoueur(String nom, String couleur, int vie, int position);
	void afficherCase(int numeroCase, int codeEffet); 
	void afficherFinPartie(String nomGagnant);
	void attendreValidation(String message); 
}