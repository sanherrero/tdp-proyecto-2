package game;

import javax.swing.ImageIcon;

public class Alimento2 extends Alimento {

	public Alimento2(Grilla g) {
		super(g);
		puntos = 75;
		increaseSize = 4;
		textura = new ImageIcon("/textures/alimentos/alimento_2.png");
	}
	
	public void action() {
		miGrilla.getSnake().aumentarTam(increaseSize);
		miGrilla.getSnake().sumarPuntos(puntos);
	}
	
}
