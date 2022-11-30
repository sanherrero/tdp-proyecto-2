package entidades.alimentos;

import entidades.PickUp;
import logica.Snake;

public abstract class Alimento extends PickUp {

	protected int puntos;
	protected int increaseSize;
	
	public Alimento(int x, int y, String img) {
		super(x, y, img);
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
	
	public void accept(Snake serpiente) {
		serpiente.visit(this);
	}
}
