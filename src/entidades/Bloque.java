package entidades;

import java.util.Random;
import logica.Snake;

public class Bloque extends Entity {

	Random r = new Random();
	protected String[] texturas = { "src/textures/blocks/bloque_0.png", "src/textures/blocks/bloque_1.png" };

	public Bloque(int x, int y) {
		super(x, y, null);
		posX = x;
		posY = y;

		if (x % 2 == 0) {
			if (y % 2 == 0)
				bloqueg.setImagen(texturas[0]);
			else
				bloqueg.setImagen(texturas[1]);
		} else {
			if (y % 2 == 0)
				bloqueg.setImagen(texturas[1]);
			else
				bloqueg.setImagen(texturas[0]);

		}

	}

	public boolean hayEspacio() {
		return true;
	}

	public void accept(Snake serpiente) {

	}

}
