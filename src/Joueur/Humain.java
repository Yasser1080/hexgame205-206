package Joueur;

import java.util.Scanner;

import Jeu.IJoueur;
import Jeu.IPlateau;

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
	public String coup_joueur(IPlateau p, int t, Scanner sc) {
		String coup;
		do{
			System.out.print("Saisissez une lettre et un numero de case  comme par exemple A1 : ");
			coup = sc.next();				
		}while(!p.verif_coup(coup));
		return coup;
	}
	

	

}
