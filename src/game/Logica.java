package game;

import gui.GUI;

public class Logica {
	protected boolean gameOver = false;
	protected GUI miGUI;
	protected Grilla tablero;
	protected Timer cronometro;
	
	public Logica(GUI g) {
		miGUI = g;
		tablero = new Grilla(this);
		cronometro = new Timer(this);
	}
	
	public boolean getGameOver() {
		return gameOver;
	}
	
	public void setGameOver() {
		gameOver = true;
	}
	
	private void siguienteNivel() {
		tablero.siguienteNivel();
	}
	//hilo de ejecucion del tiempo del juego
	private void time() {
		Thread d= new Thread(cronometro);
		d.start();	
	}
	
	
	public void actualizar() {
		
	}
	
	public int getPuntos() {
		return tablero.getSnake().getPuntaje();
	}
	
	
}
