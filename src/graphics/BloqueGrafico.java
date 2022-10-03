package graphics;

import javax.swing.ImageIcon;

public abstract class BloqueGrafico {
	protected ImageIcon texture;
	protected final String[] textures = {};
	
	public BloqueGrafico(int color) {
		this.texture = new ImageIcon(getClass().getResource(textures[color]));;
	}


	public ImageIcon getTextura() {
		return texture;
	}
}
