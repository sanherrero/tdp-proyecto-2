package logica;

import gui.GUI;
import score.Ranking;
import timers.TimerGui;
import timers.TimerSnake;

public class Logica {
	private static TimerGui timerTiempo;
	private static TimerSnake timerSerpiente;
	private Thread hiloMovSnake;
	private Thread hiloTiempo;
	private Ranking ranking;
	protected boolean gameOver = false;
	protected Grilla tablero;
	protected int puntos;
	private static Logica miLogica;
	
	public static Logica getLogica() {
		if(miLogica == null) {
			miLogica = new Logica();
		}
		return miLogica;
	}

	private Logica() {
		ranking = new Ranking();
		
		
		GUI.getGUI().setNivelActual(0);
		GUI.getGUI().setVisible(true);
		GUI.getGUI().setLblTop5(ranking.getTopFive());
		
		
		tablero = new Grilla(this);
	}

	public boolean gameOver(boolean gane) {
		stopHilos();
		timerTiempo.pararRun();
		GUI.getGUI().gameOver(gane, puntos);
		puntos = 0;
		return true;
	}

	public void siguienteNivel() {
		stopHilos();
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
		startHilos();
		tablero.getSnake().cambiarDireccion(i);		
	}
	
	public String[] getTopFive() {
		return ranking.getTopFive();
	}
	public void startHilos() {
		if(timerTiempo == null || !timerTiempo.getRun()) {
			timerTiempo = new TimerGui();
			hiloTiempo = new Thread(timerTiempo);
			hiloTiempo.start();}
		if(timerSerpiente == null || !timerSerpiente.getRun()) {

			timerSerpiente = new TimerSnake();
			hiloMovSnake = new Thread(timerSerpiente);
			hiloMovSnake.start();
		}
		
	}

	public void stopHilos() {
		
		timerSerpiente.pararRun();
	}

	public void agregarARanking(String userName,int score) {
		ranking.escribirArchivo(score, timerTiempo.getTiempo(), userName);
		ranking.ordenarLista();
		GUI.getGUI().setLblTop5(ranking.getTopFive());
		
	}
	public Ranking getRanking() {
		return ranking;
	}

	public void moverSnake() {
		tablero.getSnake().mover();	
		
	}
}