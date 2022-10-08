package game;

public class ParteCuerpoSnake extends Entity {
	
	public ParteCuerpoSnake() {
		
	}
	
	public void action(Snake serpiente) {
		serpiente.chocar();
	}
}
