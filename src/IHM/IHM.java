package IHM;

import java.util.Scanner;

import Plateau_Pion.Plateau;

public class IHM {
	
	public static void main(String[] args) {

//		String c = "Z";
//		
//		System.out.println(c.charAt(0) - 'A');
		Scanner taille_tab = new Scanner(System.in);
		System.out.println("Choisissez la taille de votre plateau :");
		Integer taille = Integer.valueOf(taille_tab.nextLine());
		IPlateau p = new Plateau(taille);


		while(true){
			try {
				System.out.println(p);
				Scanner sc = new Scanner(System.in);
				System.out.println("Saisissez une lettre et un numéro de case : ");
				String str = sc.nextLine();
				p.verif_coup(str);
				p.jouer(str);
				
				//System.out.println(p);
			}
			catch(Exception e) {
				System.out.println("Vous jouez en dehors du plateau, ou sur une case occupée, veuillez rejouez !");
			}
		}



	}
	

}
