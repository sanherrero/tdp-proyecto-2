package entidades.alimentos;

import javax.swing.ImageIcon;

public class Alimento3 extends Alimento {

	public Alimento3(int x, int y) {
		super(x, y, "src/textures/alimentos/alimento_3.png");
		puntos = 100;
		increaseSize = 5;
		
	}

	@Override
	public void accept(logica.Snake serpiente) {
		serpiente.visit(this);
		
	}
	
	
	
}
