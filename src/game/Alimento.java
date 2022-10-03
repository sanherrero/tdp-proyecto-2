package game;

public class Alimento extends Pickup {

	public Alimento(Grilla g, int points, String t) {
		super(g, points, t);
	}
	
	public void action() {
		miGrilla.getSnake().increaseSize();
	}

}
