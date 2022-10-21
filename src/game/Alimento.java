package game;

public abstract class Alimento extends Entity {

	protected int puntos;
	protected int increaseSize;
	
	public Alimento() {
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
	
	public void action(Snake serpiente) {
		serpiente.action(this);
	}
	

}
