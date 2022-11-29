package entidades.alimentos;

import logica.Snake;

public class Alimento4 extends Alimento {

	public Alimento4(int x, int y) {
		super(x, y, "src/textures/alimentos/alimento_4.png");
		puntos = 100;
		increaseSize = 6;

	}

	@Override
	public void accept(Snake serpiente) {
		serpiente.visit(this);
		
	}

}
