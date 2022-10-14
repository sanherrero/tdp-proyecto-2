package game;

import javax.swing.ImageIcon;

public class Alimento0 extends Alimento {

	public Alimento0() {
		super();
		puntos = 25;
		increaseSize = 2;
		textura = new ImageIcon("src/textures/alimentos/alimento_0.png");
	}
	
	public void action(Snake serpiente) {
		serpiente.aumentarTam(increaseSize);
		serpiente.sumarPuntos(puntos);
	}
	
}
