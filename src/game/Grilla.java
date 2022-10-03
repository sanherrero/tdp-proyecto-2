package game;

import TDAQueue.Queue;

public class Grilla {
	protected Snake serpiente;
	protected Queue<Alimento> alimentos;
	protected Queue<PowerUp> powerups;
	protected Entity[][] tablero;
	protected Logica miJuego;
	protected LevelGenerator miGenerador;
	protected int nivelActual = 0;
	
	public Grilla(Logica l) {
		miGenerador = new LevelGenerator(this);
		miJuego = l;
		nuevoNivel();
		alimentos = miGenerador.getAlimentos();
		powerups = miGenerador.getPowerUps();
	}
	
	public Snake getSnake() {
		return serpiente;
	}
	
	public void nuevoNivel() {
		tablero = miGenerador.getNivel(nivelActual);
		nivelActual++;
	}
}
