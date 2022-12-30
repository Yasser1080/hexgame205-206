package Plateau_Pion;

import java.time.format.TextStyle;

import IHM.IPlateau;

public class Plateau implements IPlateau {
	private final static int TAILLE_MAX = 26;

	private final static int NB_JOUEURS = 2;

	
	// le premier joueur relie la première et la dernière ligne
	// le premier joueur relie la première et la dernière colonne
	
	private Pion[][] t;
	private int joueur = 0; // prochain à jouer
	
	private void suivant() {
		joueur = (joueur +1) % NB_JOUEURS;
	}

	public Pion[][] getT() {
		return t;
	}
	// verifier qu'une case est occupée
	@Override
	public void verif_coup(String coord) {
		Coord c = new Coord(coord);
		int col = c.getColonne();
		int lig = c.getLigne();
		if(t[col][lig] != Pion.Vide) {
			throw new IllegalArgumentException(
					"position occupée");
		}
	}
	@Override
	public void jouer(String coord) {
		Coord c = new Coord(coord);
		assert c.estValide(taille());
		assert getCase(c) == Pion.Vide;
		Pion pion = Pion.values()[joueur];
		int col = c.getColonne();
		int lig = c.getLigne();
		System.err.println(col);
		verif_coup(coord);
		t[col][lig] = pion;
		suivant();
	}
	public static int getTaille(String pos) {
		int taille = (int) Math.sqrt(pos.length());
		assert taille * taille == pos.length();
		return taille;
	}

	
	public Pion getCase(Coord coord) {
		assert coord.estValide(taille());
		int col =coord.getColonne ();
		int lig =coord.getLigne();
		return t[col][lig];
	}


	public Plateau(int taille) {
		assert taille > 0 && taille <= TAILLE_MAX;
		t = new Pion [taille][taille];

		for (int lig = 0; lig < taille(); ++lig)
			for (int col = 0; col < taille(); ++col)
				t[col][lig] = Pion.Vide;
	}
	
	public Plateau(int taille, String pos) {
		assert taille > 0 && taille <= TAILLE_MAX;
		t = new Pion [taille][taille];
		
		String[] lignes = decouper(pos);
		
		for (int lig = 0; lig < taille(); ++lig)
			for (int col = 0; col < taille(); ++col)
				t[col][lig] = 
				  Pion.get(lignes[lig].charAt(col));
		
		if (getNb(Pion.Croix) != getNb(Pion.Rond) &&
			getNb(Pion.Croix) != (getNb(Pion.Rond)+1) &&
					getNb(Pion.Croix) != (getNb(Pion.Rond)-1))
			throw new IllegalArgumentException(
					"position non valide");
	}
	
	
	
	@Override
	public int getNb(Pion pion) {
		int nb = 0;
		for (Pion [] ligne : t)
			for (Pion p : ligne)
				if (p == pion)
					++nb;
		return nb;
	}
	@Override
	public int taille() {
		return t.length;
	}
	
	
	private String espaces(int n) {
		String s = "";
		for(int i = 0; i < n; ++i)
			s+= " ";
		return s;
	}



	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < taille(); ++i)
			s+=" "+(char)( 'A' + i);
		s+='\n';
		for (int lig = 0; lig < taille(); ++lig) {
			s+= lig+1 + espaces (lig);
			for (int col = 0; col < taille(); ++col)
				s+= " "+ t[col][lig];
			s+='\n';
		}
		return s;
	}
	public static String[] decouper(String pos) {
		int taille = getTaille(pos);
		String[] lignes = new String[taille];
		for (int i = 0; i <taille; ++i)
			lignes[i] = pos.substring(i*taille,
					(i+1)*taille);
		return lignes;
		
	}
	


	
}