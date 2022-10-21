package game;

import java.util.Random;

import javax.swing.ImageIcon;

public class Bloque extends Entity {

	Random r = new Random();
	protected String[] texturas = {"src/textures/blocks/bloque_0.png", "src/textures/blocks/bloque_1.png"};
	
	public Bloque(int corX, int corY) {
		super();
		x = corX;
		y = corY;
		if(x % 2 == 0 ) {
			if(y % 2 ==0)
				textura =new ImageIcon(texturas[0]);
			else
				textura =new ImageIcon(texturas[1]);
		}else {
			if(y % 2 ==0)
				textura =new ImageIcon(texturas[1]);
			else
				textura =new ImageIcon(texturas[0]);
			
		}
		
	}

	public void action(Snake serpiente) {
		
	}


	protected boolean hayEspacio() {
		return true;
	}
	
}
