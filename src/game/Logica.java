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
	
	
	
	
	
	
	public boolean gameOver(int score) {
		miGUI.gameOver(tablero.getTablero(),tablero.getSnake(), score);
		return true;
	}

	public void siguienteNivel() {
		miGUI.siguienteNivel(tablero.getTablero(),tablero.getSnake());
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
