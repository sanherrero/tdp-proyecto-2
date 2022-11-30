package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import entidades.alimentos.*;
import entidades.powerups.*;
import gui.BloqueGrafico;

public class Snake {

	protected Logica miJuego;
	protected GrillaNueva miGrilla;
	protected int colaAAgrandar;
	protected int x;
	protected int y;
	protected int tiempoS;
	protected int puntaje;
	protected Bloque cabeza;
	protected List<Bloque> listaCuerpo;
	protected int colorSnake = 0; // Atributo para describir el color de la snake en el momento.
	public static final int ColorDefault = 0; 
	public static final int ColorGreen = 1;
	public static final int ColorPink = 2;
	public static final int ColorRed = 3;
	protected int direccion = 0; // Atributo para describir la direccion de la snake en el momento.
	public static final int DireccionArriba = 0;
	public static final int DireccionAbajo = 1;
	public static final int DireccionIzquierda = 2;
	public static final int DireccionDerecha = 3;

	public Snake(Queue<Pos> posiciones, Logica j, GrillaNueva g) {
		miGrilla = g;
		miJuego = j;
		puntaje = 0;
		tiempoS = 0;
		listaCuerpo = new ArrayList<Bloque>();
		while (!posiciones.isEmpty()) {
			Pos pos;
			try {
				pos = posiciones.remove();
				Bloque parteNueva = new Bloque(true, pos.getX(), pos.getY(), BloqueGrafico.ImagenBodyDefault);
				listaCuerpo.add(parteNueva);
				miGrilla.add(parteNueva);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		cabeza = listaCuerpo.get(0);
		cambiarImagenCabeza();
	}

	public void aumentarTam(int cant) {
		colaAAgrandar = colaAAgrandar + cant;
	}

	public void sumarPuntos(int cant) {
		puntaje += cant;
	}

	public void visit(Alimento a) {
		miJuego.getSumaPuntos(a.getPuntos());
		this.aumentarTam(a.getIncreaseSize());
		miGrilla.agregarPickUpAleatorio();
	}

	public void visit(PowerUp0 p) {
		this.sumarPuntos(p.getPuntos());
		this.aumentarTam(p.getIncreaseSize());
		this.cambiarColor(2);
		miJuego.getSumaPuntos(p.getPuntos());
		miGrilla.agregarPickUpAleatorio();
	}

	public void visit(PowerUp1 p) {
		this.sumarPuntos(p.getPuntos());
		this.aumentarTam(p.getIncreaseSize());
		this.cambiarColor(3);
		miJuego.getSumaPuntos(p.getPuntos());
		miGrilla.agregarPickUpAleatorio();
	}

	public void visit(PowerUp2 p) {
		this.sumarPuntos(p.getPuntos());
		this.aumentarTam(p.getIncreaseSize());
		this.cambiarColor(1);
		miJuego.getSumaPuntos(p.getPuntos());
		miGrilla.agregarPickUpAleatorio();
	}

	private void cambiarColor(int color) {
		colorSnake = color;
		for (Bloque i : listaCuerpo) {
			switch (colorSnake) {
			case ColorDefault:
				i.getBloqueG().setImagen(BloqueGrafico.ImagenBodyDefault);
				break;
			case ColorGreen:
				i.getBloqueG().setImagen(BloqueGrafico.ImagenBodyGreen);
				break;
			case ColorPink:
				i.getBloqueG().setImagen(BloqueGrafico.ImagenBodyPink);
				break;
			case ColorRed:
				i.getBloqueG().setImagen(BloqueGrafico.ImagenBodyRed);
				break;
			}
		}
		cambiarImagenCabeza();
	}

	public int getPuntaje() {
		return puntaje;
	}

	public Bloque getCabeza() {
		return cabeza;
	}

	public void cambiarDireccion(int d) {
		if (d != opuesto()) {
			direccion = d;
		}
	}

	private int opuesto() {
		int toReturn = 1;
		switch(direccion) {
			case 1: {
				toReturn = 0;
				break;
			}
			case 2: {
				toReturn = 3;
				break;
			}
			case 3: {
				toReturn = 2;
				break;
			}
		}
		return toReturn;
	}
	
	public void mover() {
		if (colaAAgrandar == 0) {
			Bloque cola = listaCuerpo.remove(listaCuerpo.size() - 1);
			miGrilla.remove(cola);
		} else {
			colaAAgrandar = colaAAgrandar - 1;
		}
		int x = cabeza.getX();
		int y = cabeza.getY();
		Bloque parteAux = new Bloque(true, x, y, imagenCuerpo());
		moverCabeza();
		cambiarImagenCabeza();
		listaCuerpo.add(1, parteAux);
		miGrilla.actualizarSnake();
	}

	private String imagenCuerpo() {
		String salida = "";
		switch (colorSnake) {
		case ColorDefault:
			salida = BloqueGrafico.ImagenBodyDefault;
			break;
		case ColorGreen:
			salida = BloqueGrafico.ImagenBodyGreen;
			break;
		case ColorPink:
			salida = BloqueGrafico.ImagenBodyPink;
			break;
		case ColorRed:
			salida = BloqueGrafico.ImagenBodyRed;
			break;
		}
		return salida;
	}

	public void gameOver() {
		miGrilla.gameOver(false);
	}

	// hilo de ejecucion del tiempo de la snake

	public int getTiempo() {
		return tiempoS;
	}

	public void setTiempo(int t) {
		tiempoS = t;
	}

	public List<Bloque> getCuerpo() {
		return listaCuerpo;
	}

	public Bloque getCuerpo(int i) {
		return listaCuerpo.get(i);
	}

	public Bloque getCola() {
		return listaCuerpo.get(listaCuerpo.size() - 1);
	}

	private void moverCabeza() {
		switch (direccion) {
		case DireccionArriba:
			cabeza.setY(cabeza.getY() - 1);
			break;
		case DireccionAbajo:
			cabeza.setY(cabeza.getY() + 1);
			break;
		case DireccionIzquierda:
			cabeza.setX(cabeza.getX() - 1);
			break;
		case DireccionDerecha:
			cabeza.setX(cabeza.getX() + 1);
			break;
		}
	}

	private void cambiarImagenCabeza() {
		cabeza.getBloqueG().cambiarImagenCabezaSnake(direccion, colorSnake);
	}
}
