package game;

public abstract class Alimento extends Entity {

	protected int puntos;
	protected int increaseSize;
	
	public Alimento(Grilla g) {
		super(g);
	}
	
	public int getPuntos() {
		return puntos;
	}
	
	public abstract void action();

}
