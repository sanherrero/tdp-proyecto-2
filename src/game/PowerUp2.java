package game;

import javax.swing.ImageIcon;

public class PowerUp2 extends PowerUp{

	public PowerUp2(Grilla g) {
		super(g);
		textura = new ImageIcon("/textures/powerups/powerup_2.png");
		puntos = 100;
	}
	
	public void action() {
		miGrilla.getSnake().sumarPuntos(puntos);
		miGrilla.getSnake().aumentarTam(increaseSize);
		miGrilla.getSnake().verde();
	}

}
