package graphics;

import javax.swing.ImageIcon;

public class SnakeGrafica {
	private ImageIcon head;
	private ImageIcon body;
	
	public void updateTexture(ImageIcon h, ImageIcon b) {
		head = h;
		body = b;
	}
	
	public ImageIcon getHead() {
		return head;
	}
	
	public ImageIcon getBody() {
		return body;
	}
}
