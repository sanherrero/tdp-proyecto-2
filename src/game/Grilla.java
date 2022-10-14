package game;

import TDAQueue.*;

public class Grilla {
	int nivelActual = 0;
	protected Snake serpiente;
	protected Queue<Alimento> alimentos;
	protected Queue<PowerUp> powerups;
	protected Entity[][] tablero;
	protected Logica miJuego;
	protected LevelGenerator miGenerador;
	
	public Grilla(Logica l) {
		tablero = new Entity[20][20];
		alimentos = new LinkedQueue<Alimento>();
		powerups = new LinkedQueue<PowerUp>();
		iniciarTablero();
		miGenerador = new LevelGenerator();
		miGenerador.cargarNivel(nivelActual,alimentos, powerups, tablero);
		nivelActual++;
		miJuego = l;
		
		
		
	}
	
	//Inicia un tablero "standard" con todos bloques de fondo.
	public void iniciarTablero() {
		
		
	}
	
	
	
	public Snake getSnake() {
		return serpiente;
	}
	
	public void siguienteNivel() {
		miGenerador.cargarNivel(nivelActual,alimentos, powerups, tablero);
		nivelActual++;
	}
	
	public void checkColitions(int x, int y) {
		tablero[x][y].action(serpiente);
	}
	
	public Entity[][] getTablero(){
		return tablero;
		
	}
}
