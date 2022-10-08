package game;

import gui.GUI;

public class Logica {
	protected boolean gameOver = false;
	protected GUI miGUI;
	protected Grilla tablero;
	
	public Logica(GUI g) {
		miGUI = g;
		tablero = new Grilla(this);
	}
	
	public boolean getGameOver() {
		return gameOver;
	}
	
	public void setGameOver() {
		gameOver = true;
	}
}
