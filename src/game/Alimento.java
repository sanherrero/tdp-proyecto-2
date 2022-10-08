package game;

public abstract class Alimento extends Entity {

	protected int puntos;
	protected int increaseSize;
	
	public Alimento() {
		super();
	}
	
	public int getPuntos() {
		return puntos;
	}
	
	public abstract void action(Snake serpiente);

}
