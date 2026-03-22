package affichage;

import java.util.Scanner;

public class Affichage implements IAffichage {

	private Scanner scanner = new Scanner(System.in);

	@Override
	public void afficherDebutTour(String nomJoueurActuel) {
		System.out.println("\n===============================================");
		System.out.println("--- C'est le tour de : " + nomJoueurActuel + " ---");
	}
	
	@Override
	public void afficherResultatDe(int valeurDe) {
		System.out.println("-> Les des roulent... Resultat obtenu : " + valeurDe);
	}
	
	@Override
	public void afficherJoueur(String nom, String couleur, int vie, int position) {
		System.out.println("   Bilan " + nom + " (Pion " + couleur + ") : " + vie + " coeurs, position " + position);
	}
	
	@Override
	public void afficherCase(int numeroCase, int codeEffet) {
		System.out.println("\n-> Atterrissage sur la case numero " + numeroCase);
		
		switch (codeEffet) {
			case 1:
				System.out.println("   ROULETTE RUSSE ! Le pirate est teleporté par une faille spatio-temporelle !");
				break;
			case 2:
				System.out.println("   VOL DE VIE ! Le pirate vole un pt de vie !");
				break;
			case 0:
			default:
				System.out.println("   C'est une case normale. Rien ne se passe. ");
				break;
		}
		System.out.println("-----------------------------------------------");
	}
	
	@Override
	public void afficherFinPartie(String nomGagnant) {
		System.out.println("\n*********************************");
		System.out.println("*** FIN DE LA PARTIE !        ***");
		System.out.println("*********************************");
		System.out.println("Le gagnat est : " + nomGagnant + " !");
	}

	@Override
	public void attendreValidation(String message) {
		System.out.print(message);
		scanner.nextLine();
	}
}