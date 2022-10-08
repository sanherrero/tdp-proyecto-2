package game;

import javax.swing.ImageIcon;

public class Alimento3 extends Alimento {

	public Alimento3(Grilla g) {
		super(g);
		puntos = 100;
		increaseSize = 5;
		textura = new ImageIcon("/textures/alimentos/alimento_3.png");
	}
	
	public void action() {
		miGrilla.getSnake().aumentarTam(increaseSize);
		miGrilla.getSnake().sumarPuntos(puntos);
	}
	
}
