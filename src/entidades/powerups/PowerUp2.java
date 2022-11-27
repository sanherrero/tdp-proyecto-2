package entidades.powerups;

import javax.swing.ImageIcon;

import logica.Snake;

public class PowerUp2 extends PowerUp{

	public PowerUp2(int x , int y) {
		super(x,y,"src/textures/powerups/powerup_2.png");
		System.out.println("creo pu2");
		puntos = 100;
	}
	
	public void accept(Snake serpiente) {
		serpiente.visit(this);
	}

}
