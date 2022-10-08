package game;

import TDAQueue.*;

public class Grilla {
	protected Snake serpiente;
	protected Queue<Alimento> alimentos;
	protected Queue<PowerUp> powerups;
	protected Entity[][] tablero;
	protected Logica miJuego;
	protected LevelGenerator miGenerador;
	
	public Grilla(Logica l) {
		alimentos = new LinkedQueue<Alimento>();
		powerups = new LinkedQueue<PowerUp>();
		iniciarTablero();
		miGenerador = new LevelGenerator();
		miGenerador.cargarNivel(alimentos, powerups, tablero);
		miJuego = l;
	}
	
	//Inicia un tablero "standard" con todos bloques de fondo.
	public void iniciarTablero() {
		for(int i=0; i<20; i++) {
			for(int j=0; j<20; j++) {
				tablero[i][j] = new Bloque();
			}
		}
	}
	
	public Snake getSnake() {
		return serpiente;
	}
	
	public void siguienteNivel() {
		miGenerador.cargarNivel(alimentos, powerups, tablero);
	}
	
	public void checkColitions(int x, int y) {
		tablero[x][y].action(serpiente);
	}
}
