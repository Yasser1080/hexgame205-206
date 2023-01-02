package Jeu;

import java.util.Scanner;

public interface IJoueur {
   String getNom();
   char getType();
   String coup_joueur(IPlateau p,int t, Scanner sc);
}
