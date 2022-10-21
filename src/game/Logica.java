package game;

import gui.GUI;

public class Logica {
	protected boolean gameOver = false;
	protected GUI miGUI;
	protected Grilla tablero;
	
	public Logica() {
		tablero = new Grilla(this);
		
		miGUI = new GUI(tablero.getSnake());
		miGUI.setVisible(true);
		
		
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

	
	public void actualizar() {
		miGUI.actualizar(tablero.getTablero());
	}
	
	public int getPuntos() {
		return tablero.getSnake().getPuntaje();
	}
	
	public Grilla getGrilla() {
		return tablero;
	}
	
}
