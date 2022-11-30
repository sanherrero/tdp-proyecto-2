package entidades.alimentos;

import logica.Snake;

public class Alimento0 extends Alimento {

	public Alimento0(int x, int y) {
		super(x, y, "src/textures/alimentos/alimento_0.png");
		puntos = 25;
		increaseSize = 2;
	}

	public void accept(Snake serpiente) {
		serpiente.visit(this);		
	}
}
