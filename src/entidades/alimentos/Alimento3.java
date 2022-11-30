package entidades.alimentos;

import logica.Snake;

public class Alimento3 extends Alimento {

	public Alimento3(int x, int y) {
		super(x, y, "src/textures/alimentos/alimento_3.png");
		puntos = 100;
		increaseSize = 5;
	}

	public void accept(Snake serpiente) {
		serpiente.visit(this);
	}
}
