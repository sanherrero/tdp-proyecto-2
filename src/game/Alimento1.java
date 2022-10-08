package game;

import javax.swing.ImageIcon;

public class Alimento1 extends Alimento {

	public Alimento1(Grilla g) {
		super(g);
		puntos = 50;
		increaseSize = 3;
		textura = new ImageIcon("/textures/alimentos/alimento_1.png");
	}
	
	public void action() {
		miGrilla.getSnake().aumentarTam(increaseSize);
		miGrilla.getSnake().sumarPuntos(puntos);
	}
	
}
