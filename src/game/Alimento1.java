package game;

import javax.swing.ImageIcon;

public class Alimento1 extends Alimento {

	public Alimento1() {
		super();
		puntos = 50;
		increaseSize = 3;
		textura = new ImageIcon("/textures/alimentos/alimento_1.png");
	}
	
	public void action(Snake serpiente) {
		serpiente.aumentarTam(increaseSize);
		serpiente.sumarPuntos(puntos);
	}
	
}
