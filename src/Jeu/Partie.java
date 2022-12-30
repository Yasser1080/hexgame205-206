package Jeu;

import java.util.ArrayList;

import IHM.IPartie;
import Plateau_Pion.Coord;
import Plateau_Pion.Pion;

// On a choisis que les pions 'X' doivent relier la partie gauche à la droite pour gagner
// et les pions 'O' doivent relier la partie haute et basse pour gagner
public class Partie implements IPartie{
	private int taille;
	private Pion t[][] ;
	@Override
	public boolean EstFini() {
		boolean estfini = false;
		for (int lig = 0; lig < t.length; ++lig) {
			for (int col = 0; col <t.length; ++col) {
				if (!t[col][lig].equals(Pion.Vide) ) {
					estfini = true;
				}
			}
				
		}
		return estfini;
	}
	
	//renvoyer une liste des pions autour à partir d'une position
	public ArrayList<Pion> liste_pion(String coord) {
		Coord c = new Coord(coord);
		int col = c.getColonne();
		int lig = c.getLigne();
		ArrayList<Pion> liste_pion = new ArrayList<Pion>();
		liste_pion.add(t[col][lig-1]); //en haut a gauche
		liste_pion.add(t[col+1][lig-1]); //en haut a droite
		liste_pion.add(t[col+1][lig]); // a droite
		liste_pion.add(t[col][lig+1]); //en bas a droite
		liste_pion.add(t[col-1][lig+1]); // en bas a gauche
		liste_pion.add(t[col-1][lig]); // a gauche
		return liste_pion;
	}
	
	public boolean bordure_gagnante(String coord) {
		boolean bordure_est_gagnante = false;
		Coord c = new Coord(coord);
		int col = c.getColonne();
		int lig = c.getLigne();
		if(t[col][lig] == Pion.Croix ) {
			
		}
		return false;
	}


	//boucler sur le tableau des pions
	//comparer si le pion de la pos i avec la pos i+1
	@Override
	public boolean EstGagne() {
		
		// TODO Auto-generated method stub
		return false;
	}

}