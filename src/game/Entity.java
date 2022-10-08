package game;

import javax.swing.ImageIcon;

public abstract class Entity {
	protected Grilla miGrilla;
	protected ImageIcon textura;
	
	public Entity(Grilla g) {
		miGrilla = g;
	}
	
	public abstract void action();
	
}
