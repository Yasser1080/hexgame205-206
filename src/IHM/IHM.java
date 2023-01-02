package IHM;

import java.util.Scanner;

import Jeu.Partie;



public class IHM {
	
	public static void main(String[] args) {


		System.out.println("Bienvenue dans le jeu Hex !");
		Scanner sc = new Scanner(System.in);
		System.out.print("Choisissez la taille de votre plateau : ");
		int taille = sc.nextInt();

		IPartie partie = new Partie(taille);

		partie.lancer_partie(0);
		
		sc.close();



	}


}
