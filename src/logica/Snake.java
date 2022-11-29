package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import entidades.Pared;
import entidades.ParteCuerpoSnake;
import entidades.alimentos.*;
import entidades.powerups.*;

public class Snake {

	protected Logica miJuego;
	protected Grilla miGrilla;
	protected int colaAAgrandar;
	protected int x;
	protected int y;
	protected int tiempoS;
	protected int puntaje;
	protected ParteCuerpoSnake cabeza;
	protected List<ParteCuerpoSnake> listaCuerpo;
	protected int colorSnake = 0; // atributo para describir el color de la snake en el momento 0->default,
									// 1->green, 2->pink y 3->red
	protected int direccion = 0; // atributo para describir la direccion de la snake en el momento 0->arriba,
									// 1->abajo, 2->izquierda y 3->derecha
	protected String[] cabezaDefault = { "src/textures/hd/head-top-default.png",
			"src/textures/hd/head-bottom-default.png", "src/textures/hd/head-left-default.png",
			"src/textures/hd/head-right-default.png" };
	protected String[] cabezaGreen = { "src/textures/hg/head-top-green.png", "src/textures/hg/head-bottom-green.png",
			"src/textures/hg/head-left-green.png", "src/textures/hg/head-right-green.png" };
	protected String[] cabezaPink = { "src/textures/hp/head-top-pink.png", "src/textures/hp/head-bottom-pink.png",
			"src/textures/hp/head-left-pink.png", "src/textures/hp/head-right-pink.png" };
	protected String[] cabezaRed = { "src/textures/hr/head-top-red.png", "src/textures/hr/head-bottom-red.png",
			"src/textures/hr/head-left-red.png", "src/textures/hr/head-right-red.png" };

	public Snake(Queue<Pos> posiciones, Logica j, Grilla g) {
		listaCuerpo = new ArrayList<ParteCuerpoSnake>();
		while (!posiciones.isEmpty()) {
			Pos pos;
			try {
				pos = posiciones.remove();
				listaCuerpo.add(new ParteCuerpoSnake(pos.getX(), pos.getY(), colorSnake));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		crearCabeza(listaCuerpo.get(0));

		miGrilla = g;
		miJuego = j;

		puntaje = 0;
		tiempoS = 0;

	}

	public void aumentarTam(int cant) {
		colaAAgrandar = colaAAgrandar + cant;
	}

	public void sumarPuntos(int cant) {
		puntaje += cant;

	}

	public void visit(Pared p) {
		gameOver();
	}

	public void visit(ParteCuerpoSnake p) {
		gameOver();
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
		for (ParteCuerpoSnake i : listaCuerpo) {
			i.cambiarColor(colorSnake);
		}
		cambiarImagenCabeza();

	}

	public int getPuntaje() {
		return puntaje;
	}

	public ParteCuerpoSnake getCabeza() {
		return cabeza;
	}

	public void cambiarDireccion(int d) {
		if (!(d == 0 && direccion == 1) && !(d == 1 && direccion == 0) && !(d == 2 && direccion == 3)
				&& !(d == 3 && direccion == 2))
			direccion = d;
	}

	public void mover() {
		
		if (colaAAgrandar == 0) {
			ParteCuerpoSnake cola = listaCuerpo.remove(listaCuerpo.size() - 1);
			miGrilla.eliminarColaDelTablero(cola);
		} else {
			colaAAgrandar = colaAAgrandar - 1;
		}

		int x = cabeza.getX();
		int y = cabeza.getY();

		ParteCuerpoSnake parteAux = new ParteCuerpoSnake(x, y, colorSnake);
		moverCabeza();
		cambiarImagenCabeza();
		listaCuerpo.add(1, parteAux);
		miGrilla.actualizarPosSnake(cabeza, parteAux);
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

	private void crearCabeza(ParteCuerpoSnake c) {
		cabeza = c;
		cabeza.setImagen(cabezaDefault[direccion]);

	}

	public List<ParteCuerpoSnake> getCuerpo() {
		return listaCuerpo;
	}

	public ParteCuerpoSnake getCuerpo(int i) {
		return listaCuerpo.get(i);
	}

	public ParteCuerpoSnake getCola() {
		return listaCuerpo.get(listaCuerpo.size() - 1);
	}

	private void moverCabeza() {
		switch (direccion) {
		case 0:
			cabeza.setY(cabeza.getY() - 1);
			break;
		case 1:
			cabeza.setY(cabeza.getY() + 1);
			break;
		case 2:
			cabeza.setX(cabeza.getX() - 1);
			break;
		case 3:
			cabeza.setX(cabeza.getX() + 1);
			break;
		}
	}

	private void cambiarImagenCabeza() {

		switch (colorSnake) {
		case 0:
			cabeza.setImagen(cabezaDefault[direccion]);
			break;
		case 1:
			cabeza.setImagen(cabezaGreen[direccion]);
			break;
		case 2:
			cabeza.setImagen(cabezaPink[direccion]);
			break;
		case 3:
			cabeza.setImagen(cabezaRed[direccion]);
			break;
		}

	}

}
