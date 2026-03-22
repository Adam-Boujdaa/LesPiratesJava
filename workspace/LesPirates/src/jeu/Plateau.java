package jeu;

import cases.Case;               
import cases.CaseNormale;        
import cases.CaseRouletteRusse;  
import cases.CaseVolVie;      

public class Plateau {

	public static final int NB_CASES = 30;
	private int[] posCaseRouletteRusse;
	private int[] posCaseVolVie;
	private Case casedebut;
	private Case caseFin;
	
	public Plateau() {
		posCaseRouletteRusse = new int[]{5, 15, 25};
		posCaseVolVie = new int[]{10, 20};
		casedebut = new CaseNormale(1);
		caseFin = new CaseNormale(NB_CASES);
	}

	public Case getCase(int position) {
		if (position <= 1) return casedebut;
		if (position >= NB_CASES) return caseFin;
		
		for (int p : posCaseRouletteRusse) {
			if (p == position) return new CaseRouletteRusse(position);
		}
		for (int p : posCaseVolVie) {
			if (p == position) return new CaseVolVie(position);
		}
		
		return new CaseNormale(position);
	}
}