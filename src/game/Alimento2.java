package game;

import javax.swing.ImageIcon;

public class Alimento2 extends Alimento {

	public Alimento2() {
		super();
		puntos = 75;
		increaseSize = 4;
		textura = new ImageIcon("src/textures/alimentos/alimento_2.png");
	}
	
	public void action(Snake serpiente) {
		serpiente.aumentarTam(increaseSize);
		serpiente.sumarPuntos(puntos);
	}
	
}
