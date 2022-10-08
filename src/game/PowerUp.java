package game;

public abstract class PowerUp extends Entity {

	protected int puntos;
	protected final int increaseSize = 3;
	
	public PowerUp() {
		super();
	}
	
	public abstract void action(Snake serpiente);
	
}
