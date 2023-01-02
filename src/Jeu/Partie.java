package Jeu;
import IHM.*;

import Joueur.Humain;
import Joueur.Machine;
import Plateau_Pion.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



//On a choisis que les pions 'X' doivent relier la partie haute et basse pour gagner
//et les pions 'O' doivent relier la partie gauche et la droite pour gagner
public class Partie implements IPartie{

	private final int MIN_TAILL = 3, MAX_TAILL = 26;
	private IPlateau plateau;
	private IJoueur j1, j2;
	private Scanner sc = new Scanner(System.in);

	public Partie(int taillePlateau) {
		assert(MIN_TAILL <= taillePlateau && taillePlateau >= MAX_TAILL);
		this.plateau = FactoryPlateau.getNewPlateau(taillePlateau);
	}

	public Partie(int taillePlateau, String pos) {
		assert(MIN_TAILL <= taillePlateau && taillePlateau >= MAX_TAILL);
		this.plateau = FactoryPlateau.getNewPlateau(taillePlateau, pos);
	}

	/**
	 * Verifie s'il n'y a plus de place dans le plateau pour ajouter des pions
	 * @return
	 */
	public boolean estFini() {
		return plateau.getNb(Pion.Vide) == 0;
	}


	public void jouerPartie(){
		System.out.println(plateau);
		String coup;
		while(!estFini()){
			System.out.println(j1.getNom() + " a vous de positionner votre pion");
			coup = j1.coup_joueur(plateau, plateau.taille(),sc);
			plateau.jouer(coup);
			System.out.println(j1.getNom() + " a postionne son pion a la case " + coup);
			System.out.println(plateau);
			
			System.out.println(j2.getNom() + " a vous de positionner votre pion");
			coup = j2.coup_joueur(plateau, plateau.taille(),sc);
			plateau.jouer(coup);
			System.out.println(j2.getNom() + " a postionne son pion a la case " + coup);
			System.out.println(plateau);
//			if(EstGagne(Pion.Croix)){
//				System.out.println("Vainqueur X");
//				break;
//			}
//			if(EstGagne(Pion.Rond)) {
//				System.out.println("Vainqueur 0");
//				break;
//			}
				

			
		}
		// regle de fin de jeu : un des joueur a gagne ou le plateau est plein
		//affichage de celui qui a gagner
	}
	
	public void lancer_partie(int choix) {
		switch (choix) {
			case 0:
				System.out.print("Saisiez votre pseudo joueur 1 : ");
				String pseudo = sc.nextLine();
				this.j1 = new Humain(pseudo);
				System.out.print("Saisiez votre pseudo joueur 2 : ");
				pseudo = sc.nextLine();
				this.j2 = new Humain(pseudo);
				break;
			case 1:
				System.out.print("Saisiez votre pseudo joueur 1 : ");
				pseudo = sc.nextLine();
				this.j1 = new Humain(pseudo);
				this.j2 = new Machine();
				break;
			case 2:
//				System.out.print("Saisiez votre pseudo joueur 1 : ");
//				pseudo = sc.nextLine();
				this.j1 = new Machine();
				this.j2 = new Machine();
				break;
			default:
				System.out.print("Saisiez votre pseudo joueur 1 : ");
				pseudo = sc.nextLine();
				this.j1 = new Humain(pseudo);
				this.j2 = new Machine();
				break;
		}	
		jouerPartie();
	}
	
	
	
	
	private List<Coord> getCaseAdjacent(Coord c ){
		int x = c.getLigne();
		int y = c.getColonne();
		List<Coord> caseAdjacent = new ArrayList<>();
		caseAdjacent.add(new Coord(x,y + 1));
		caseAdjacent.add(new Coord(x,y - 1));
		caseAdjacent.add(new Coord(x + 1,y));
		caseAdjacent.add(new Coord(x + 1,y - 1));
		caseAdjacent.add(new Coord(x -1,y));
		caseAdjacent.add(new Coord(x -1,y + 1));
		
		for(int i = 0 ; i < caseAdjacent.size() ; i++) {
			if(!caseAdjacent.get(i).estValide(plateau.taille()) && plateau.getCase(caseAdjacent.get(i)) != plateau.getCase(c)) {
				caseAdjacent.remove(i);
			}
		}
		
		return caseAdjacent ;
		
	}
	
	private boolean EstVoisin(Coord c , List<Coord> ListeDesVoisins, List<Coord> ListeArrivee) {
		boolean verif = false;
		if(ListeArrivee.contains(c)) {
			return true;
		}
		for(Coord co : getCaseAdjacent(c)) {
			if(ListeDesVoisins.contains(co))
				continue ;
			ListeDesVoisins.add(co);
			verif = verif || EstVoisin(c, ListeDesVoisins, ListeArrivee);
		}
		
		return verif;
		
	}
	
	public boolean EstGagne(Pion p) {
		// ligne = croix et colonne = 0
		
		List<Coord> Arrivee = new ArrayList();
		List<Coord> Depart = new ArrayList();
		List<Coord> ListeVoisin = new ArrayList();
		
		// verifier quelle case de c = p 
		Coord c, co;
		for(int i = 0 ; i < plateau.taille(); i++) {
			if(p == Pion.Croix) {
				 c = new Coord(0,i);
				 co = new Coord(plateau.taille()-1,i);
			}
			else {
				 c = new Coord(i,0);
				 co = new Coord(i,plateau.taille()-1);
			}
				
			 
			if(plateau.getCase(c) == p ) {
				Depart.add(c);
			}
			if(plateau.getCase(co) == p ) {
				Arrivee.add(co);
			}
		}
		 if(Arrivee.size() == 0 || Depart.size() == 0)
			 return false;
		 
		 for(Coord c1 : Depart) {
			 if(EstVoisin(c1, ListeVoisin, Arrivee))
				 return true;
			 
		 }
		return false;
	}



}