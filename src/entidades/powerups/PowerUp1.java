package entidades.powerups;


import logica.Snake;

public class PowerUp1 extends PowerUp{

	public PowerUp1(int x , int y) {
		super(x,y,"src/textures/powerups/powerup_1.png");
		puntos = 75;
	}
	
	public void accept(Snake serpiente) {
		serpiente.visit(this);
	}

	

}
