package entidades;

import javax.swing.ImageIcon;

import gui.BloqueGrafico;
import logica.Snake;

public abstract class Entity {

	protected BloqueGrafico bloqueg;
	protected int posX;
	protected int posY;

	public Entity(int x, int y, String img) {
		posX = x;
		posY = y;
		bloqueg = new BloqueGrafico(x,y,img);
		
	}

	public int getX() {
		return posX;
	}

	public int getY() {
		return posY;
	}

	public void setX(int x) {
		posX = x;
		bloqueg.setPosition(posX, posY);
	}

	public void setY(int y) {
		posY = y;
		bloqueg.setPosition(posX, posY);
	}
	
	public BloqueGrafico getBloqueG() {
		return bloqueg;
	}

	public abstract void accept(Snake serpiente);

	public abstract boolean hayEspacio();

}
