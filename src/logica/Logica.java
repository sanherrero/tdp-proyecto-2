package logica;

import gui.GUI;
import score.Ranking;

public class Logica {
	protected boolean gameOver = false;
	protected Ranking ranking;
	protected Grilla tablero;
	protected int puntos;
	private static Logica miLogica;
	
	public static Logica getLogica() {
		if(miLogica == null)
			miLogica = new Logica();
		return miLogica;
	}

	private Logica() {
		tablero = new Grilla(this);
		ranking = new Ranking();
		GUI.getGUI().setNivelActual(0);
		GUI.getGUI().setVisible(true);
		

	}

	public boolean gameOver(boolean gane) {
		GUI.getGUI().gameOver(gane, puntos);
		puntos = 0;
		return true;
	}

	public void siguienteNivel() {
		
		GUI.getGUI().siguienteNivel(tablero.getNivel());
		tablero.siguienteNivel();
	}

	

	public int getPuntos() {
		return puntos;
	}

	public Grilla getGrilla() {
		return tablero;
	}

	public int getSumaPuntos(int p) {
		puntos = puntos + p;
		GUI.getGUI().actualizarPuntuacion(puntos);
		return puntos;
	}

	public void cambiarDireccionSnake(int i) {
		tablero.getSnake().cambiarDireccion(i);
		
	}
	
	public String[] getTopFive() {
		return ranking.getTopFive();
	}

}
