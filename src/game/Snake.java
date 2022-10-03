package game;

import javax.swing.ImageIcon;

import graphics.SnakeGrafica;

public class Snake {
	
	private SnakeGrafica textura;
	
	public void increaseSize() {
		
	}
	
	public void changeColor(ImageIcon head, ImageIcon body) {
		textura.updateTexture(head, body);
	}
}
