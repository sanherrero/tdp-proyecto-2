package game;

import javax.swing.ImageIcon;

public class ParteCuerpoSnake extends Entity {
	protected String[] texturas = {"src/textures/bodies/body-default.png", "src/textures/bodies/body-green.png","src/textures/bodies/body-pink.png","src/textures/bodies/body-red.png"};
	public ParteCuerpoSnake() {
		textura =new ImageIcon(texturas[0]);
		
	}
	
	public void action(Snake serpiente) {
		serpiente.chocar();
	}
	
	public void cambiarColor(int c) {
		textura = new ImageIcon(texturas[c]);
	}
	protected boolean hayEspacio() {
		return false;
	}
	
}
