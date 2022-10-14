package game;

import javax.swing.ImageIcon;

public class Alimento3 extends Alimento {

	public Alimento3() {
		super();
		puntos = 100;
		increaseSize = 5;
		textura = new ImageIcon("src/textures/alimentos/alimento_3.png");
	}
	
	public void action(Snake serpiente) {
		serpiente.aumentarTam(increaseSize);
		serpiente.sumarPuntos(puntos);
	}
	
}
