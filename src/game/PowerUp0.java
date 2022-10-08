package game;

import javax.swing.ImageIcon;

public class PowerUp0 extends PowerUp{

	public PowerUp0() {
		super();
		textura = new ImageIcon("/textures/powerups/powerup_0.png");
		puntos = 50;
	}
	
	public void action(Snake serpiente) {
		serpiente.sumarPuntos(puntos);
		serpiente.aumentarTam(increaseSize);
		serpiente.rosa(); //PowerUp0 cambia la textura a rosa.
	}

}
