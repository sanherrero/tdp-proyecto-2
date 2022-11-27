package gui;

import javax.swing.ImageIcon;

public class BloqueGrafico {
	protected ImageIcon imagen;
	protected int x, y;

	public BloqueGrafico() {
		imagen = new ImageIcon();
	}

	public BloqueGrafico(int x,int y,String img) {
		this.x=x;
		this.y=y;
		imagen = new ImageIcon(img);
		imagen = new ImageIcon(imagen.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
		GUI.getGUI().addBloqueGrafico(this);
	}

	public void setImagen(String img) {
		imagen = new ImageIcon(img);
		GUI.getGUI().addBloqueGrafico(this);

	}

	

	public ImageIcon getImagen() {
		return imagen;
	}
	
	public void setPosition(int x,int y) {
		this.x=x;
		this.y=y;
		GUI.getGUI().addBloqueGrafico(this);
	}
	
	public int getX() {
		return x;
		
	}
	
	public int getY() {
		return y;
	}
}
