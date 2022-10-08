package game;

import javax.swing.ImageIcon;

public class PowerUp1 extends PowerUp{

	public PowerUp1() {
		super();
		textura = new ImageIcon("/textures/powerups/powerup_1.png");
		puntos = 75;
	}
	
	public void action(Snake serpiente) {
		serpiente.sumarPuntos(puntos);
		serpiente.aumentarTam(increaseSize);
		serpiente.rojo(); //PowerUp0 cambia la textura a rojo.
	}

}
