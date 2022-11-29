package entidades;
import logica.Snake;

public class Pared extends Entity {

	public Pared(int x, int y) {
		super(x, y, "src/textures/blocks/wall.png");
	}

	public void accept(Snake serpiente) {
		serpiente.visit(this);
	}
	
	public boolean hayEspacio() {
		return false;
	}

}
