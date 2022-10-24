package game;

import gui.GUI;

public class Logica {
	protected boolean gameOver = false;
	protected GUI miGUI;
	protected Grilla tablero;
	protected int puntos;
	
	public Logica() {
		tablero = new Grilla(this);
		
		miGUI = new GUI(tablero.getSnake());
		miGUI.setNivelActual(tablero.getNivel());
		miGUI.setVisible(true);
		
		
	}
	
	
	
	
	
	
	public boolean gameOver(boolean gane,int score) {
		miGUI.gameOver(gane,tablero.getTablero(),tablero.getSnake(), score);
		return true;
	}

	public void siguienteNivel() {
		miGUI.siguienteNivel(tablero.getTablero(),tablero.getSnake(),tablero.getNivel());
	}

	
	public void actualizar() {
		miGUI.actualizar(tablero.getTablero());
	}
	
	public int getPuntos() {
		return puntos;
	}
	
	public Grilla getGrilla() {
		return tablero;
	}
	
	public void sumarPuntos(int p) {
		puntos = puntos +p;
	}
	
}
