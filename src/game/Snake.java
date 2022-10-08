package game;

import graphics.SnakeGrafica;

public class Snake {
	
	protected SnakeGrafica textura;
	protected Logica miJuego;
	protected Grilla miGrilla;
	protected int tamActual;
	protected int movActual;
	protected int x;
	protected int y;
	
	
	public Snake(Logica j, Grilla g) {
		miGrilla = g;
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
	
	/**
	 * Se pasa el movimiento actual para ver qué textura usar.
	 * 0 = up
	 * 1 = right
	 * 2 = down
	 * 3 = left
	 */
	
	public void rosa() {
		textura.rosa(movActual); //Llama al rosa de su representación gráfica pasándole su movimiento actual
	}
	
	public void rojo() {
		textura.rojo(movActual); //Llama al rojo de su representación gráfica pasándole su movimiento actual
	}
	
	public void verde() {
		textura.verde(movActual); //Llama al verde de su representación gráfica pasándole su movimiento actual
	}
	
	public void chocar() {
		miJuego.setGameOver();
	}
	
	//Pasa al checkColotions las coordenadas del bloque que va a chocar.
	
	public void moverArriba() {
		movActual = 0;
		miGrilla.checkColitions(x, y-1);
	}
	
	public void moverAbajo() {
		movActual = 2;
		miGrilla.checkColitions(x, y+1);
	}
	
	public void moverDerecha() {
		movActual = 1;
		miGrilla.checkColitions(x+1, y);
	}
	
	public void moverIzquierda() {
		movActual = 3;
		miGrilla.checkColitions(x-1, y);
	}
	
	public void gameOver() {
		miJuego.setGameOver();
	}
	
	public int getMovimientoActual() {
		return movActual;
	}
}
