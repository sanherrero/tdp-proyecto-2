package game;

import java.util.ArrayList;
import java.util.List;

import graphics.SnakeGrafica;

public class Snake {
	
	protected SnakeGrafica textura;
	protected Logica miJuego;
	protected Grilla miGrilla;
	protected int tamActual;
	protected int movActual;
	protected int x;
	protected int y;
	protected Timer cronometroSnake;
	protected int tiempoS;
	protected int puntaje;
	protected List<ParteCuerpoSnake> lista;
	protected int colorSnake = 0; // atributo para describir el color de la snake en el momento 1->default, 2->green, 3->pink y 4->red
	
	public Snake(Logica j, Grilla g) {
		lista = new ArrayList<ParteCuerpoSnake>();
		miGrilla = g;
		textura = new SnakeGrafica();
		miJuego = j;
		tamActual = 3;
		movActual = 0;
		puntaje = 0;
		tiempoS=0;
		tiempo();
	}
	
	public void aumentarTam(int cant) {
		tamActual+=cant;
	}
	
	public void sumarPuntos(int cant) {		
		puntaje+=cant;
		
	}
	
	public int getPuntaje() {
		return puntaje;	
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
	//hilo de ejecucion del tiempo de la snake
	private void tiempo() {
		cronometroSnake= new Timer(this,0.5);
		Thread d= new Thread(cronometroSnake);
		d.start();	
	}
	public int getTiempo() {
		return tiempoS;
	}
	public void setTiempo(int t) {
		tiempoS=t;
	};
	
}
