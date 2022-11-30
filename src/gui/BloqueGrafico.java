package gui;

import javax.swing.ImageIcon;

import entidades.PickUp;
import entidades.alimentos.*;
import entidades.powerups.*;
import logica.Snake;

public class BloqueGrafico {
	
	public static final String ImagenBloque0 = "src/textures/blocks/bloque_0.png";
	public static final String ImagenBloque1 = "src/textures/blocks/bloque_1.png";
	public static final String ImagenWall = "src/textures/blocks/wall.png";
	public static final String ImagenAlimento0 = "src/textures/alimentos/alimento_0.png";
	public static final String ImagenAlimento1 = "src/textures/alimentos/alimento_1.png";
	public static final String ImagenAlimento2 = "src/textures/alimentos/alimento_2.png";
	public static final String ImagenAlimento3 = "src/textures/alimentos/alimento_3.png";
	public static final String ImagenAlimento4 = "src/textures/alimentos/alimento_4.png";
	public static final String ImagenPowerUp0 = "src/textures/powerups/powerup_0.png";
	public static final String ImagenPowerUp1 = "src/textures/powerups/powerup_1.png";
	public static final String ImagenPowerUp2 = "src/textures/powerups/powerup_2.png";
	public static final String ImagenBodyDefault = "src/textures/bodies/body-default.png";
	public static final String ImagenBodyGreen = "src/textures/bodies/body-green.png";
	public static final String ImagenBodyPink = "src/textures/bodies/body-pink.png";
	public static final String ImagenBodyRed = "src/textures/bodies/body-red.png";
	public static final String ImagenAbajoDefault = "src/textures/hd/head-bottom-default.png";
	public static final String ImagenArribaDefault = "src/textures/hd/head-top-default.png";
	public static final String ImagenDerechaDefault = "src/textures/hd/head-right-default.png";
	public static final String ImagenIzquierdaDefault = "src/textures/hd/head-left-default.png";
	public static final String ImagenAbajoGreen = "src/textures/hg/head-bottom-green.png";
	public static final String ImagenArribaGreen = "src/textures/hg/head-top-green.png";
	public static final String ImagenDerechaGreen = "src/textures/hg/head-right-green.png";
	public static final String ImagenIzquierdaGreen = "src/textures/hg/head-left-green.png";
	public static final String ImagenAbajoPink = "src/textures/hp/head-bottom-pink.png";
	public static final String ImagenArribaPink = "src/textures/hp/head-top-pink.png";
	public static final String ImagenDerechaPink = "src/textures/hp/head-right-pink.png";
	public static final String ImagenIzquierdaPink = "src/textures/hp/head-left-pink.png";
	public static final String ImagenAbajoRed = "src/textures/hr/head-bottom-red.png";
	public static final String ImagenArribaRed = "src/textures/hr/head-top-red.png";
	public static final String ImagenDerechaRed = "src/textures/hr/head-right-red.png";
	public static final String ImagenIzquierdaRed = "src/textures/hr/head-left-red.png";
	
	protected ImageIcon imagen;
	protected int x, y;

	public BloqueGrafico(int x, int y, String img) {
		this.x = x;
		this.y = y;
		imagen = new ImageIcon(img);
		imagen = new ImageIcon(imagen.getImage().getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH));
		GUI.getGUI().addBloqueGrafico(this);
	}

	public void setImagen(String img) {
		imagen = new ImageIcon(img);
		GUI.getGUI().addBloqueGrafico(this);
	}
	
	public void setImagen (Alimento0 a) {
		setImagen(ImagenAlimento0);
	}
	public void setImagen (Alimento1 a) {
		setImagen(ImagenAlimento1);
	}
	public void setImagen (Alimento2 a) {
		setImagen(ImagenAlimento2);
	}
	public void setImagen (Alimento3 a) {
		setImagen(ImagenAlimento3);
	}
	public void setImagen (Alimento4 a) {
		setImagen(ImagenAlimento4);
	}
	public void setImagen (PowerUp0 a) {
		setImagen(ImagenPowerUp0);
	}
	public void setImagen (PowerUp1 a) {
		setImagen(ImagenPowerUp1);
	}
	public void setImagen (PowerUp2 a) {
		setImagen(ImagenPowerUp2);
	}

	public ImageIcon getImagen() {
		return imagen;
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
		GUI.getGUI().addBloqueGrafico(this);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public void setImagen(Alimento a) {
		
	}

	public void setImagen(PowerUp p) {
		
	}

	public void cambiarImagenCabezaSnake(int direccion, int colorSnake) {

		switch(direccion) {
		case Snake.DireccionArriba:
			switch (colorSnake) {
			case Snake.ColorDefault:
				setImagen(BloqueGrafico.ImagenArribaDefault);
				break;
			case Snake.ColorGreen:
			    setImagen(BloqueGrafico.ImagenArribaGreen);
				break;
			case Snake.ColorPink:
				setImagen(BloqueGrafico.ImagenArribaPink);
				break;
			case Snake.ColorRed:
				setImagen(BloqueGrafico.ImagenArribaRed);
				break;
			}
			break;
		case Snake.DireccionAbajo:
			switch (colorSnake) {
			case Snake.ColorDefault:
				setImagen(BloqueGrafico.ImagenAbajoDefault);
				break;
			case Snake.ColorGreen:
				setImagen(BloqueGrafico.ImagenAbajoGreen);
				break;
			case Snake.ColorPink:
				setImagen(BloqueGrafico.ImagenAbajoPink);
				break;
			case Snake.ColorRed:
				setImagen(BloqueGrafico.ImagenAbajoRed);
				break;
			}
			break;
		case Snake.DireccionDerecha:
			switch (colorSnake) {
			case Snake.ColorDefault:
				setImagen(BloqueGrafico.ImagenDerechaDefault);
				break;
			case Snake.ColorGreen:
				setImagen(BloqueGrafico.ImagenDerechaGreen);
				break;
			case Snake.ColorPink:
				setImagen(BloqueGrafico.ImagenDerechaPink);
				break;
			case Snake.ColorRed:
				setImagen(BloqueGrafico.ImagenDerechaRed);
				break;
			}
			break;
		case Snake.DireccionIzquierda:
			switch (colorSnake) {
			case Snake.ColorDefault:
				setImagen(BloqueGrafico.ImagenIzquierdaDefault);
				break;
			case Snake.ColorGreen:
				setImagen(BloqueGrafico.ImagenIzquierdaGreen);
				break;
			case Snake.ColorPink:
				setImagen(BloqueGrafico.ImagenIzquierdaPink);
				break;
			case Snake.ColorRed:
				setImagen(BloqueGrafico.ImagenIzquierdaRed);
				break;
			}
			break;
		}
	}

	public void setImagen(PickUp p) {
		// TODO Auto-generated method stub
		
	}		
}