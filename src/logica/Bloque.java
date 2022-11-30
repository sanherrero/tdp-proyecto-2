package logica;

import entidades.alimentos.Alimento;
import entidades.powerups.PowerUp;
import gui.BloqueGrafico;

public class Bloque {
	protected int posX, posY;
	protected boolean ocupado;
	protected Alimento alimento;
	protected PowerUp powerup;
	protected BloqueGrafico bloqueg;

	public Bloque(boolean ocupado, int x, int y) { // Si al momento de crearse ya esta ocupado es por que es una pared, en caso contrario es un bloque transitable
		posX = x;
		posY = y;
		this.ocupado = ocupado;
		if (ocupado) {
			bloqueg = new BloqueGrafico(posX,posY,BloqueGrafico.ImagenWall);
		}else {
			bloqueg = new BloqueGrafico(posX,posY,selecionarImagen());
		}
	}
	
	public Bloque(boolean ocupado, int x, int y,String img) { // Si al momento de crearse ya esta ocupado es por que es una pared, en caso contrario es un bloque transitable
		posX = x;
		posY = y;
		this.ocupado = ocupado;
		bloqueg = new BloqueGrafico(posX,posY,img);
		
	}
	
	private String selecionarImagen() {
		String salida ="";
		if (posX % 2 == 0) {
			if (posY % 2 == 0)
				salida =BloqueGrafico.ImagenBloque0;
			else
				salida =BloqueGrafico.ImagenBloque1;
		} else {
			if (posY % 2 == 0)
				salida =BloqueGrafico.ImagenBloque1;
			else
				salida =BloqueGrafico.ImagenBloque0;

		}
		return salida;
	}

	public boolean estaOcupado() {
		return ocupado;
	}
	
	public void desocupar() {
		ocupado = false;
		bloqueg.setImagen(selecionarImagen());
	}
	
	public void ocupar(Snake s) {
		if(ocupado) {
			s.gameOver();
		}else {
			ocupado = true;
			if(powerup != null)
				powerup.accept(s);
			if(alimento != null)
				alimento.accept(s);
		}
		
		
		
	}
	
	public void setBloqueG(BloqueGrafico bg) {
		bloqueg = bg;
	}
	
	public void agregarPickUp(Alimento a) {
		alimento =a;
		bloqueg.setImagen(a);
		
	}
	public void agregarPickUp(PowerUp p) {
		powerup =p;
		bloqueg.setImagen(p);
		
	}

	public BloqueGrafico getBloqueG() {
		return bloqueg;
		
	}
	
	public int getY() {
		return posY;
	}
	public int getX() {
		return posX;
	}
	
	public void setY(int y) {
		posY = y;
		bloqueg.setPosition(posX, posY);
	}
	
	public void setX(int x) {
		posX = x;
		bloqueg.setPosition(posX, posY);
	}

}
