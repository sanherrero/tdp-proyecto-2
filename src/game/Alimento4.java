package game;

import javax.swing.ImageIcon;

public class Alimento4 extends Alimento {

	public Alimento4(Grilla g) {
		super(g);
		puntos = 100;
		increaseSize = 6;
		textura = new ImageIcon("/textures/alimentos/alimento_4.png");
	}
	
	public void action() {
		miGrilla.getSnake().aumentarTam(increaseSize);
		miGrilla.getSnake().sumarPuntos(puntos);
	}
	
}
