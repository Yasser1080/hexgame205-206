package Joueur;

import IHM.IJoueur;

public class Humain implements IJoueur{
	private String nom;
	private char type;
	
	public Humain(String c) {
		this.nom = c;
		this.type = 'H';
	}
	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return nom;
	}
	@Override
	public char getType() {
		return type;
	}
	@Override
	public String jouer_coup() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
