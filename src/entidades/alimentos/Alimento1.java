package entidades.alimentos;



public class Alimento1 extends Alimento {

	public Alimento1(int x, int y) {
		super(x, y, "src/textures/alimentos/alimento_1.png");
		puntos = 50;
		increaseSize = 3;
		
	}

	@Override
	public void accept(logica.Snake serpiente) {
		serpiente.visit(this);
		
	}
	
	
	
}
