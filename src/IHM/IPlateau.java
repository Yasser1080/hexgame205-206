package IHM;

import Plateau_Pion.Pion;

public interface IPlateau {

    void jouer(String coord);
    void verif_coup(String coord);
    int getNb(Pion pion);
    int taille();
    String toString();
}
