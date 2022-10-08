package graphics;

import javax.swing.ImageIcon;

public class SnakeGrafica {
	
	protected ImageIcon[] heads = Heads.getTexturas();
	protected ImageIcon[] bodies = Bodies.getTexturas();
	protected ImageIcon head;
	protected ImageIcon body;
	
	public SnakeGrafica() {
		setDefault();
	}
	
	//Se recibe el movimiento de la snake y se toma la textura correspondiente
	
	public void rosa(int mov) {
		switch (mov) {
			case 0: head = heads[Heads.UP_PINK];
			case 1: head = heads[Heads.RIGHT_PINK];
			case 2: head = heads[Heads.DOWN_PINK];
			case 3: head = heads[Heads.LEFT_PINK];
		}
		body = bodies[Bodies.BODY_PINK];
	}
	
	public void rojo(int mov) {
		switch (mov) {
			case 0: head = heads[Heads.UP_RED];
			case 1: head = heads[Heads.RIGHT_RED];
			case 2: head = heads[Heads.DOWN_RED];
			case 3: head = heads[Heads.LEFT_RED];
		}
		body = bodies[Bodies.BODY_RED];
	}
	
	public void verde(int mov) {
		switch (mov) {
			case 0: head = heads[Heads.UP_GREEN];
			case 1: head = heads[Heads.RIGHT_GREEN];
			case 2: head = heads[Heads.DOWN_GREEN];
			case 3: head = heads[Heads.LEFT_GREEN];
		}
		body = bodies[Bodies.BODY_GREEN];
	}
	
	public void setDefault() {
		head = heads[Heads.UP_DEFAULT];
		body = bodies[Bodies.BODY_DEFAULT];
	}
	
	public ImageIcon getHead() {
		return head;
	}
	
	public ImageIcon getBody() {
		return body;
	}
	
	static class Bodies {
		
		static ImageIcon[] texturas = new ImageIcon[4];
		
		static final int BODY_DEFAULT = 0;
		static final int BODY_PINK = 1;
		static final int BODY_RED = 2;
		static final int BODY_GREEN = 3;
		
		static ImageIcon[] getTexturas() {
			texturas[BODY_DEFAULT] = new ImageIcon("/textures/bodies/body-default.png");
			texturas[BODY_PINK] = new ImageIcon("/textures/bodies/body-pink.png");
			texturas[BODY_RED] = new ImageIcon("/textures/bodies/body-red.png");
			texturas[BODY_GREEN] = new ImageIcon("/textures/bodies/body-green.png");
			
			return texturas;
		}
		
	}
	
	static class Heads {
		
		static ImageIcon[] texturas = new ImageIcon[16];
		
		static final int UP_DEFAULT = 0;
		static final int UP_PINK = 1;
		static final int UP_RED = 2;
		static final int UP_GREEN = 3;
		static final int RIGHT_DEFAULT = 4;
		static final int RIGHT_PINK = 5;
		static final int RIGHT_RED = 6;
		static final int RIGHT_GREEN = 7;
		static final int DOWN_DEFAULT = 8;
		static final int DOWN_PINK = 9;
		static final int DOWN_RED = 10;
		static final int DOWN_GREEN = 11;
		static final int LEFT_DEFAULT = 12;
		static final int LEFT_PINK = 13;
		static final int LEFT_RED = 14;
		static final int LEFT_GREEN = 15;
		
		static ImageIcon[] getTexturas() {
			texturas[UP_DEFAULT] = new ImageIcon("/textures/hd/head-top-default.png");
			texturas[UP_PINK] = new ImageIcon("/textures/hp/head-top-pink.png");
			texturas[UP_RED] = new ImageIcon("/textures/hr/head-top-red.png");
			texturas[UP_GREEN] = new ImageIcon("/textures/hg/head-top-green.png");
			texturas[RIGHT_DEFAULT] = new ImageIcon("/textures/hd/head-right-default.png");
			texturas[RIGHT_PINK] = new ImageIcon("/textures/hp/head-right-pink.png");
			texturas[RIGHT_RED] = new ImageIcon("/textures/hr/head-right-red.png");
			texturas[RIGHT_GREEN] = new ImageIcon("/textures/hg/head-right-green.png");
			texturas[DOWN_DEFAULT] = new ImageIcon("/textures/hd/head-down-default.png");
			texturas[DOWN_PINK] = new ImageIcon("/textures/hp/head-down-pink.png");
			texturas[DOWN_RED] = new ImageIcon("/textures/hr/head-down-red.png");
			texturas[DOWN_GREEN] = new ImageIcon("/textures/hg/head-down-green.png");
			texturas[LEFT_DEFAULT] = new ImageIcon("/textures/hd/head-left-default.png");
			texturas[LEFT_PINK] = new ImageIcon("/textures/hp/head-left-pink.png");
			texturas[LEFT_RED] = new ImageIcon("/textures/hr/head-left-red.png");
			texturas[LEFT_GREEN] = new ImageIcon("/textures/hg/head-left-green.png");
			
			return texturas;
		}
	}
}
