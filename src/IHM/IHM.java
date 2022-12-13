package IHM;

import java.util.Scanner;

import sources.hex.Plateau;

public class IHM {
	
	public static void main(String[] args) {
		
		Plateau p = new Plateau(6);
		IHM ihm = new IHM();
		ihm.jouer_coup(p);;
	}
	
	public IHM() {
		
	}
	
	public void jouer_coup(Plateau p) {
		
	    while(p.jeu_fini() == false) {
			for(int i = 0; i < p.taille(); i++) {
				System.out.println(p);
				Scanner sc = new Scanner(System.in);
			    System.out.println("Saisissez une lettre et un numéro de case : ");
			    String str = sc.nextLine();
			    p.jouer(str);
			    System.out.println(p);
			}
		}
	}
	
//	public void jouer_partie(Plateau p) {
//		while(p.jeu_fini() == false) {
//			for(int i = 0; i < p.taille(); i++) {
//				jouer_coup(p);
//			}
//		}
//	}
}
