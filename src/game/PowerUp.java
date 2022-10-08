package game;

public abstract class PowerUp extends Entity {

	protected int puntos;
	protected final int increaseSize = 3;
	
	public PowerUp(Grilla g) {
		super(g);
	}
	
	public abstract void action();
	
}
