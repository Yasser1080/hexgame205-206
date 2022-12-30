package Joueur;

import java.util.Random;

import IHM.IJoueur;

public class Machine implements IJoueur{
	private int cpt = 0;
	private char type = 'M';
	
	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return "Joueur " + cpt;
	}

	@Override
	public char getType() {
		// TODO Auto-generated method stub
		return type;
	}

	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	@Override
	public String jouer_coup() {
		// TODO Auto-generated method stub
		getRandomNumberInRange(0,taille);
		return null;
	}
	
	
	
}
