package game;

import javax.swing.ImageIcon;

public class PowerUp2 extends PowerUp{

	public PowerUp2() {
		super();
		textura = new ImageIcon("/textures/powerups/powerup_2.png");
		puntos = 100;
	}
	
	public void action(Snake serpiente) {
		serpiente.sumarPuntos(puntos);
		serpiente.aumentarTam(increaseSize);
		serpiente.verde(); //PowerUp0 cambia la textura a verde.
	}

}
