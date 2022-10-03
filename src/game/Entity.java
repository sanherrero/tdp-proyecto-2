package game;

import javax.swing.ImageIcon;

public abstract class Entity {
	protected Grilla miGrilla;
	protected ImageIcon textura;
	
	public Entity(Grilla g, String t) {
		miGrilla = g;
		textura = new ImageIcon(t);
	}
	
	public abstract void action();
}
