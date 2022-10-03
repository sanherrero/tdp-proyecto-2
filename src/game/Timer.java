package game;

public class Timer implements Runnable {

	private double time;
	private Logica juego;
	
	public void run() {
		while(!juego.getGameOver()) {
			time++;
		}
	}

}
