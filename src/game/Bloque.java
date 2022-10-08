package game;

import java.util.Random;

import javax.swing.ImageIcon;

public class Bloque extends Entity {
	
	Random r = new Random();
	protected String[] texturas = {"/textures/blocks/bloque_0.png", "/textures/blocks/bloque_1.png"};
	
	public Bloque(Grilla g) {
		super(g);
		textura = new ImageIcon(texturas[r.nextInt(2)]);
	}

	public void action() {
		
	}
	
}
