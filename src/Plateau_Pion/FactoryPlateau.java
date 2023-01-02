package Plateau_Pion;

public class FactoryPlateau {

	public static Plateau getNewPlateau(int t) {
		return new Plateau(t);
	}
	
	public static Plateau getNewPlateau(int t, String pos) {
		return new Plateau(t, pos);
	}
	
}
