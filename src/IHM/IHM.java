package IHM;

import java.util.Scanner;

import Jeu.Regles;
import Plateau_Pion.Plateau;

public class IHM {
	
	public static void main(String[] args) {
		
		Plateau p = new Plateau(6);
		IHM ihm = new IHM();
		Regles r = new Regles();
		ihm.jouer(p);
	}
	
	public IHM() {
		
	}
	
//	public void jouer(Plateau p) {
//		try {
//			for(int i = 0; i < p.taille(); i++)
//					jouer_partie(p);
//		}
//	    catch(Exception e) {
//				for(int i = 0; i < p.taille(); i++) {
//			    	System.out.println("Vous jouez en dehors du plateau, veuillez ressaisir un coup :");
//			    	jouer_partie(p);
//				}
//			}
//		jouer_partie(p);
//	    }
	
	
	public void jouer(Plateau p) {
		try {
			System.out.println(p);
			Scanner sc = new Scanner(System.in);
		    System.out.println("Saisissez une lettre et un numéro de case : ");
		    String str = sc.nextLine();
		    p.jouer(str);
		    System.out.println(p);
		}
		catch(Exception e) {
			System.out.println("Vous jouez en dehors du plateau, rejouez");
		}
	}
}
