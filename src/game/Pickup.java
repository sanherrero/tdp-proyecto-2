package game;

public abstract class Pickup extends Entity {
	
	protected int puntos;
	
	public Pickup(Grilla g, int points, String t) {
		super(g, t);
		puntos = points;
	}
	
	public int getPuntos() {
		return puntos;
	}
}
