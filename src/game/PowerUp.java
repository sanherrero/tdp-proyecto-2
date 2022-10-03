package game;

import javax.swing.ImageIcon;

public class PowerUp extends Pickup {

	private ImageIcon newHead;
	private ImageIcon newBody;
	
	public PowerUp(Grilla g, int points, String t, String nh, String nb) {
		super(g, points, t);
		newHead = new ImageIcon(nh);
		newBody = new ImageIcon(nb);
	}
	
	public void action() {
		miGrilla.getSnake().changeColor(newHead, newBody);
	}
	
}
