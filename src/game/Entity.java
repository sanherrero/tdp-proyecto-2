package game;

import javax.swing.ImageIcon;

public abstract class Entity {
	
	protected ImageIcon textura;
	protected int x;
	protected int y;
	
	public Entity() {
		x = 0;
		y = 0;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setImagen(ImageIcon i) {
		textura=i;
	}
	
	public ImageIcon getImagen() {
		return textura;
	}
	
	public abstract void action(Snake serpiente);
	
}
