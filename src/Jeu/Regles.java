package Jeu;

import Plateau_Pion.Pion;
import Plateau_Pion.Plateau;

public class Regles {
	//V�rifier si un pion est d�j� pr�sent sur une case avant de jouer
	//R�gle du gateau
	//R�gle ne pas pouvoir jouer en dehors du plateau (une case inexistante)
	//R�gle ne pas pouvoir �crire n'importe quoi (une lettre et un chiffre)
	public Regles() {
		
	}
	
	public boolean verif_case_vide(Plateau p) {
		for (int lig = 0; lig < p.taille(); ++lig)
			for (int col = 0; col < p.taille(); ++col)
				if(p.t[col][lig] == Pion.Vide) {
					
				}
				
		return false;
	}
	
	public void jouer_partie(Plateau p) {
		while(p.jeu_fini() == false) {
			for(int i = 0; i < p.taille(); i++) {
				
			}
		}
	}
	
}
