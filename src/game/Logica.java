package game;

import gui.GUI;

public class Logica {
	protected boolean gameOver = false;
	protected GUI miGUI;
	protected Grilla tablero;
	
	public Logica() {
		tablero = new Grilla(this);
		
		miGUI = new GUI(tablero.getSnake());
		miGUI.setNivelActual(tablero.getNivel());
		miGUI.setVisible(true);
		
		
	}
	
	
	
	
	
	
	public void gameOver() {
		miGUI.gameOver(tablero.getTablero(),tablero.getSnake());
		
	}

	public void siguienteNivel() {
		miGUI.siguienteNivel(tablero.getTablero(),tablero.getSnake(),tablero.getNivel());
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
