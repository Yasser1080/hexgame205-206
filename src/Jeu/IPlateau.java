package Jeu;

import Plateau_Pion.*;

public interface IPlateau {

    void jouer(String coord);
    boolean verif_coup(String coord);
    int getNb(Pion pion);
    Pion getCase(Coord c);
    int taille();
    String toString();
    Pion[][] getT();
}
