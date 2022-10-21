package game;

public abstract class PowerUp extends Entity {

	protected int puntos;
	protected final int increaseSize = 3;
	
	public PowerUp() {
		super();
	}
	protected boolean hayEspacio() {
		return false;
	}
	public int getPuntos() {
		return puntos;
	}
	public int getIncreaseSize() {
		return increaseSize;
	}
	public abstract void action(Snake serpiente);
	
}
