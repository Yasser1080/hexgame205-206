package Plateau_Pion;



public class Coord {
    private final int TAILLE_COORD = 3; //?
    private String xy;

    private int x,y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

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
    // la fonction verifie que les coordonn�es sont compos�es est de taille 2
    public boolean estValide(int taille) {
 
        if ( 1 > getXy().length() && this.getXy().length() < TAILLE_COORD )
            return false;
   
        int col = getColonne();
        int lig = getLigne();
        if (col < 0 || col > taille)
            return false;
        
        if (lig < 0 || lig > taille)
            return false;
        
        return true;
    }


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coord other = (Coord) obj;
		if (TAILLE_COORD != other.TAILLE_COORD)
			return false;
		if (x != other.x)
			return false;
		if (xy == null) {
			if (other.xy != null)
				return false;
		} else if (!xy.equals(other.xy))
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public int getColonne() {
        return this.getXy().charAt(0)- PREMIERE_COLONNE;
    }

    public int getLigne() {
        return this.getXy().charAt(1) - PREMIERE_LIGNE;
    }
    
    public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append((char)(getColonne() + PREMIERE_COLONNE));
		sb.append(getLigne()+1);
		return sb.toString();
	}
    
}
