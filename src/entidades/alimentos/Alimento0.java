package entidades.alimentos;

import javax.swing.ImageIcon;

import logica.Snake;

public class Alimento0 extends Alimento {

	public Alimento0(int x, int y) {
		super(x, y, "src/textures/alimentos/alimento_0.png");
		puntos = 25;
		increaseSize = 2;
	}

	@Override
	public void accept(logica.Snake serpiente) {
		serpiente.visit(this);
		
	}

	

}
