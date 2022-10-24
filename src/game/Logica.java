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
	
	
	
	
	
	
	public boolean gameOver(boolean gane) {
		miGUI.gameOver(gane,tablero.getTablero(),tablero.getSnake(), puntos);
		puntos = 0;
		return true;
	}

	public void siguienteNivel() {
		miGUI.siguienteNivel(tablero.getTablero(),tablero.getSnake(),tablero.getNivel());
	}

	
	public void actualizar() {
		miGUI.actualizar(tablero.getTablero(), puntos);
	}
	
	public int getPuntos() {

		return tablero.getSnake().getPuntaje();
	}
	
	public int getSumaPuntos(int p) {
		puntos += p;
		return puntos;
	}
	
	public Grilla getGrilla() {
		return tablero;
	}
	
}
