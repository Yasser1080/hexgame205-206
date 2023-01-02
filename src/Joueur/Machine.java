package Joueur;

import java.util.Random;
import java.util.Scanner;

import Jeu.IJoueur;
import Jeu.IPlateau;



public class Machine implements IJoueur {
	
	private static int cpt = 0;
	private char type = 'M';
	private String nom;
	
	public Machine() {
		nom = "M" + cpt++;
	}
	
	@Override
	public String getNom() {
		return nom;
	}

	@Override
	public char getType() {
		return type;
	}
	
	@Override
	public String coup_joueur(IPlateau p, int taille, Scanner sc) {
		int a1;
		int a2;
		char a1c;
		do {
			a1 = (int) (Math.random() * (taille-1))+1;
			a2 = (int) (Math.random() * (taille-1))+1;
			a1c = (char)(a1 +'A') ;
		}while (!p.verif_coup(""+a1c+a2));
		return "" + a1c+a2 ;
	}


	
	
}
