package game;

import javax.swing.ImageIcon;

public class Pared extends Entity {

	public Pared() {
		super();
		textura = new ImageIcon("src/textures/blocks/wall.png");
	}

	public void action(Snake serpiente) {
		serpiente.action(this);
	}
	
	protected boolean hayEspacio() {
		return false;
	}

}
