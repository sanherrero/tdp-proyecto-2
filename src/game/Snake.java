package game;

import javax.swing.ImageIcon;

import graphics.SnakeGrafica;

public class Snake {
	
	private SnakeGrafica textura;
	private Logica miJuego;
	
	public Snake(SnakeGrafica t, Logica j) {
		textura = t;
		miJuego = j;
	}
	
	public void increaseSize() {
		
	}
	
	public void changeColor(ImageIcon head, ImageIcon body) {
		textura.updateTexture(head, body);
	}
	
	public void chocar() {
		miJuego.setGameOver();
	}
}
