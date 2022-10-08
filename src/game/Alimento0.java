package game;

import javax.swing.ImageIcon;

public class Alimento0 extends Alimento {

	public Alimento0(Grilla g) {
		super(g);
		puntos = 25;
		increaseSize = 2;
		textura = new ImageIcon("/textures/alimentos/alimento_0.png");
	}
	
	public void action() {
		miGrilla.getSnake().aumentarTam(increaseSize);
		miGrilla.getSnake().sumarPuntos(puntos);
	}
	
}
