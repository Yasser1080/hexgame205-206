package Joueur;

import IHM.IJoueur;

public class Humain implements IJoueur {
	private String nom;
	private char type;
	private int score;
	public Humain(String c){
	    this.nom = c;
	    this.type = 'H';
	}
	@Override
	public String getNom() {
		return nom;
	}
	@Override
	public Integer getScore() {
		return score;
	}
}