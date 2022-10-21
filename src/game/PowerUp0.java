package game;

import javax.swing.ImageIcon;

public class PowerUp0 extends PowerUp{

	public PowerUp0() {
		super();
		textura = new ImageIcon("src/textures/powerups/powerup_0.png");
		puntos = 50;
	}
	
	public void action(Snake serpiente) {
		serpiente.action(this);
	}

}
