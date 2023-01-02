package tests.hex;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import IHM.IPartie;
import Jeu.Partie;
import Plateau_Pion.*;
class PlateauTest {
	private String pos1 = ".X..XOXXOO.OX..."; 
	private String[] lignes1_rep = {
			".X..", 
			"XOXX",
			"OO.O",
			"X..."
	};
	private String display1_rep = 
			" A B C D\n" + 
			"1 . X . .\n" + 
			"2  X O X X\n" + 
			"3   O O . O\n" + 
			"4    X . . .\n";

	@Test
	void test() {
		final int taille = 4;
		Plateau p = new Plateau(taille);
		assertEquals(taille, p.taille());
		assertEquals(
				" A B C D\n" + 
				"1 . . . .\n" + 
				"2  . . . .\n" + 
				"3   . . . .\n" + 
				"4    . . . .\n", p.toString());
		
	
		// jouer un coup en B2
		p.jouer("B2");
		assertEquals(Pion.Croix, p.getCase(new Coord("B2")));
		System.out.println(p);
		
		p.jouer("C2");
		assertEquals(Pion.Rond, p.getCase(new Coord("C2")));
		System.out.println(p);
		
		// nouveaux tests
		
				IPartie partie = new Partie(taille);

				partie.lancer_partie(0);
				
		
	}
	
	@Test
	public void testerPositions() {
		testerPosition(pos1, lignes1_rep, display1_rep);
	}

	private void testerPosition(String pos, String[] lignes_rep, String display_rep) {
		String[] lignes;
		lignes  = Plateau.decouper(pos);
		int taille = Plateau.getTaille(pos);
		
		for (int i = 0; i< taille; ++i)
			assertEquals(lignes_rep[i], lignes[i]);
		
		Plateau p = new Plateau(taille, pos);
		assertEquals(display_rep, p.toString());
		
	}
	private void testerjeu() {
		Partie p1 = new Partie(4);
		
	}
	
	
	

}
