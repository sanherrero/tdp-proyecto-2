package logica;

import java.util.ArrayDeque;
import java.util.Queue;
import entidades.alimentos.*;
import entidades.powerups.*;

public class Grilla {
	
	int nivelActual = 0;
	protected Snake serpiente;
	protected Queue<Integer> alimentos;
	protected Queue<Integer> powerups;
	protected Bloque[][] tablero;
	protected Logica miJuego;
	protected LevelGenerator miGenerador;

	public Grilla(Logica l) {
		tablero = new Bloque[20][20];
		alimentos = new ArrayDeque<Integer>();
		powerups = new ArrayDeque<Integer>();
		miGenerador = new LevelGenerator();
		Queue<Pos> posSnake = miGenerador.cargarNivel(nivelActual, alimentos, powerups, tablero);
		miJuego = l;
		serpiente = new Snake(posSnake, miJuego, this);
		for (Bloque i : serpiente.getCuerpo()) {
			tablero[i.getX()][i.getY()] = i;
		}
		agregarPickUpAleatorio();
	}

	public Snake getSnake() {
		return this.serpiente;
	}

	public void siguienteNivel() {
		if (nivelActual == 5) {
			gameOver(true);
		} else {
			Queue<Pos> posSnake = miGenerador.cargarNivel(nivelActual, alimentos, powerups, tablero);
			serpiente = new Snake(posSnake, miJuego, this);
			for (Bloque i : serpiente.getCuerpo()) {
				tablero[i.getX()][i.getY()] = i;
			}
			agregarPickUpAleatorio();
		}
	}

	public void gameOver(boolean gane) {
		nivelActual = 0;
		Queue<Pos> posSnake = miGenerador.cargarNivel(nivelActual, alimentos, powerups, tablero);
		nivelActual++;
		serpiente = new Snake(posSnake, miJuego, this);
		for (Bloque i : serpiente.getCuerpo()) {
			tablero[i.getX()][i.getY()] = i;
		}
		agregarPickUpAleatorio();
		miJuego.gameOver(gane);
	}

	public void checkColitions() {
		int posXCabeza = serpiente.getCabeza().getX();
		int posYCabeza = serpiente.getCabeza().getY();
		tablero[posXCabeza][posYCabeza].ocupar(serpiente);
	}

	public int getNivel() {
		return nivelActual;
	}

	public void agregarPickUpAleatorio() {
		int numRandom = (int) (Math.random() * 2);
		try {
			Pos posAux = buscarLugar();
			if (!alimentos.isEmpty() && !powerups.isEmpty()) {
				if (numRandom == 0) {
					crearAlimento(alimentos.remove(), posAux);
				} else {
					crearPowerUp(powerups.remove(), posAux);
				}
			} else {
				if (alimentos.isEmpty() && powerups.isEmpty()) {
					nivelActual++;
					logica.Logica.getLogica().siguienteNivel();
				} else {
					if (!alimentos.isEmpty() && powerups.isEmpty()) {
						crearAlimento(alimentos.remove(), posAux);
					} else {
						crearPowerUp(powerups.remove(), posAux);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void add(Bloque b) {
		int x = b.getX();
		int y = b.getY();
		tablero[x][y] = b;
	}
	
	public void remove(Bloque b) {
		int x = b.getX();
		int y = b.getY();
		tablero[x][y] = new Bloque(false,x,y);
	}

	private void crearAlimento(Integer i, Pos p) {
		int x = p.getX();
		int y = p.getY();
		switch (i) {
		case 0:
			tablero[x][y].agregarPickUp(new Alimento0(x, y));
			break;
		case 1:
			tablero[x][y].agregarPickUp(new Alimento1(x, y));
			break;
		case 2:
			tablero[x][y].agregarPickUp(new Alimento2(x, y));
			break;
		case 3:
			tablero[x][y].agregarPickUp(new Alimento3(x, y));
			break;
		case 4:
			tablero[x][y].agregarPickUp(new Alimento4(x, y));
			break;
		}
	}

	private void crearPowerUp(Integer i, Pos p) {
		int x = p.getX();
		int y = p.getY();
		switch (i) {
		case 0:
			tablero[x][y].agregarPickUp(new PowerUp0(x, y));
			break;
		case 1:
			tablero[x][y].agregarPickUp(new PowerUp1(x, y));
			break;
		case 2:
			tablero[x][y].agregarPickUp(new PowerUp2(x, y));
			break;
		}
	}

	private Pos buscarLugar() {
		boolean hayLugar = false;
		int posXRandom = 0;
		int posYRandom = 0;
		while (hayLugar == false) {
			posXRandom = (int) (Math.random() * 19);
			posYRandom = (int) (Math.random() * 19);
			hayLugar = !tablero[posXRandom][posYRandom].estaOcupado();
		}
		return new Pos(posXRandom, posYRandom);
	}

	public void actualizarSnake() {
		Bloque c = serpiente.getCabeza();
		int x = c.getX();
		int y = c.getY();
		tablero[x][y].ocupar(serpiente);
	}
}
