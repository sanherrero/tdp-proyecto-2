package game;

import javax.swing.ImageIcon;

public abstract class Pickup extends Entity {
	
	protected int puntos;
	protected ImageIcon textura;
	
	public Pickup(Grilla g, int points, String t) {
		super(g, t);
		puntos = points;
		textura = new ImageIcon(t);
	}
	
	public int getPuntos() {
		return puntos;
	}
}
