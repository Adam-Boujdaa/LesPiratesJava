package jeu;


import java.security.SecureRandom;
import java.util.Random;


public class De {

	private Random random;
	
	
	public De() {
		try {
            this.random = SecureRandom.getInstanceStrong(); 
        } catch (Exception e) {
            this.random = new Random();
        }
	}
	
	
	public int lancerDes() {
        int r1 = random.nextInt(6)+1;
        int r2 = random.nextInt(6)+1;
        return r1+r2;
	}

	
}
