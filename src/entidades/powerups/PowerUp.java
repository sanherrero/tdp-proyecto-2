package entidades.powerups;

import entidades.Entity;
import logica.Snake;

public abstract class PowerUp extends Entity {

	protected int puntos;
	protected final int increaseSize = 3;
	
	public PowerUp(int x,int y,String img) {
		super(x,y,img);
	}
	public boolean hayEspacio() {
		return false;
	}
	public int getPuntos() {
		return puntos;
	}
	public int getIncreaseSize() {
		return increaseSize;
	}
	public abstract void accept(Snake serpiente);
	
}
