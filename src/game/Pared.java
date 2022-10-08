package game;

import javax.swing.ImageIcon;

public class Pared extends Entity {

	public Pared() {
		super();
		textura = new ImageIcon("/textures/blocks/wall.png");
	}

	public void action(Snake serpiente) {
		serpiente.gameOver();
	}

}
