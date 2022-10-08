package game;

import javax.swing.ImageIcon;

public class PowerUp0 extends PowerUp{

	public PowerUp0(Grilla g) {
		super(g);
		textura = new ImageIcon("/textures/powerups/powerup_0.png");
		puntos = 50;
	}
	
	public void action() {
		miGrilla.getSnake().sumarPuntos(puntos);
		miGrilla.getSnake().aumentarTam(increaseSize);
		miGrilla.getSnake().rosa();
	}

}
