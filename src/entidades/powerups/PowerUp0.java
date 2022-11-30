package entidades.powerups;

import logica.Snake;

public class PowerUp0 extends PowerUp {

	public PowerUp0(int x, int y) {
		super(x, y, "src/textures/powerups/powerup_0.png");
		puntos = 50;
	}

	public void accept(Snake serpiente) {
		serpiente.visit(this);
	}

}
