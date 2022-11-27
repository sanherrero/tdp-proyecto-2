package entidades;

import javax.swing.ImageIcon;

import gui.GUI;
import logica.Snake;

public class ParteCuerpoSnake extends Entity {
	protected static String[] texturas = {"src/textures/bodies/body-default.png", "src/textures/bodies/body-green.png","src/textures/bodies/body-pink.png","src/textures/bodies/body-red.png"};
	public ParteCuerpoSnake(int x,int y , int t) {
		super(x,y,texturas[t]);
		
	}
	
	public void accept(Snake serpiente) {
		serpiente.visit(this);
	}
	
	public void cambiarColor(int c) {
		bloqueg.setImagen(texturas[c]);
	}
	public boolean hayEspacio() {
		return false;
	}

	public void setImagen(String ruta) {
		bloqueg.setImagen(ruta);
		
	}
	
}
