package game;

import graphics.SnakeGrafica;

public class Snake {
	
	protected SnakeGrafica textura;
	protected Logica miJuego;
	protected int tamActual;
	protected int movActual;
	
	
	public Snake(Logica j) {
		textura = new SnakeGrafica();
		miJuego = j;
		tamActual = 3;
		movActual = 0;
	}
	
	public void aumentarTam(int cant) {
		tamActual+=cant;
	}
	
	public void sumarPuntos(int cant) {
		
	}
	
	public void rosa() {
		textura.rosa(movActual);
	}
	
	public void rojo() {
		textura.rojo(movActual);
	}
	
	public void verde() {
		textura.verde(movActual);
	}
	
	public void chocar() {
		miJuego.setGameOver();
	}
	
	public void moverArriba() {
		movActual = 0;
	}
	
	public void moverAbajo() {
		movActual = 2;
	}
	
	public void moverDerecha() {
		movActual = 1;
	}
	
	public void moverIzquierda() {
		movActual = 3;
	}
	
	public void gameOver() {
		miJuego.setGameOver();
	}
}
