package Plateau_Pion;

public class Coord {
    private final int TAILLE_COORD = 2;
    private String xy;
    private final static int PREMIERE_COLONNE = 'A';
    private final static int PREMIERE_LIGNE = '1';

    public Coord(String xy) {
        this.xy = xy;
    }

    public int getTAILLE_COORD() {
        return TAILLE_COORD;
    }

    public String getXy() {
        return xy;
    }

    public void setXy(String xy) {
        this.xy = xy;
    }
    // la fonction verifie que les coordonnées sont composées est de taille 2
    public boolean estValide(int taille) {
        if ( this.getXy().length() != TAILLE_COORD )
            return false;
        int col = getColonne();
        int lig = getLigne();
        System.out.println(this.xy + " "+ col+ " "+ lig);
        if (col < 0 || col >= taille)
            return false;
        if (lig <0 || lig >= taille)
            return false;
        return true;
    }
    public int getColonne() {
        return this.getXy().charAt(0)- PREMIERE_COLONNE;
    }

    public int getLigne() {
        return this.getXy().charAt(1)- PREMIERE_LIGNE;
    }
}
