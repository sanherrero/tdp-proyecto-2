package entidades.alimentos;

import logica.Snake;

public class Alimento2 extends Alimento {

	public Alimento2(int x, int y) {
		super(x, y, "src/textures/alimentos/alimento_2.png");
		puntos = 75;
		increaseSize = 4;
		
	}

	@Override
	public void accept(Snake serpiente) {
		serpiente.visit(this);
		
	}
	
}
