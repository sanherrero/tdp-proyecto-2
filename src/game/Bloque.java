package game;

import java.util.Random;

import javax.swing.ImageIcon;

public class Bloque extends Entity {

	Random r = new Random();
	protected String[] texturas = {"src/textures/blocks/bloque_0.png", "src/textures/blocks/bloque_1.png"};
	
	public Bloque() {
		super();
		textura = new ImageIcon(texturas[r.nextInt(2)]); //Textura aleatoria entre las 2 posibles
	}

	public void action(Snake serpiente) {
		switch(serpiente.getMovimientoActual()) {
			case 0: serpiente.moverArriba();
			case 1: serpiente.moverDerecha();
			case 2: serpiente.moverAbajo();
			case 3: serpiente.moverIzquierda();
		}
	}
	
}
