package game;

import javax.swing.ImageIcon;

public class PowerUp1 extends PowerUp{

	public PowerUp1() {
		super();
		textura = new ImageIcon("src/textures/powerups/powerup_1.png");
		puntos = 75;
	}
	
	public void action(Snake serpiente) {
		serpiente.action(this);
	}

}
