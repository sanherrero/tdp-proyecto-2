package game;

import javax.swing.ImageIcon;

public class PowerUp1 extends PowerUp{

	public PowerUp1(Grilla g) {
		super(g);
		textura = new ImageIcon("/textures/powerups/powerup_1.png");
		puntos = 75;
	}
	
	public void action() {
		miGrilla.getSnake().sumarPuntos(puntos);
		miGrilla.getSnake().aumentarTam(increaseSize);
		miGrilla.getSnake().rojo();
	}

}
