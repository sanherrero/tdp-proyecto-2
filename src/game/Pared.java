package game;

import javax.swing.ImageIcon;

public class Pared extends Entity {

	public Pared(Grilla g) {
		super(g);
		textura = new ImageIcon("/textures/blocks/wall.png");
	}

	public void action() {
		miGrilla.getSnake().gameOver();
	}

}
