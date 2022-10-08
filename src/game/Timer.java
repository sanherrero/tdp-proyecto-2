package game;

public class Timer implements Runnable {

	private double time;
	private Logica juego;
	
	public Timer(Logica s) {
		juego = s;
		time = 0;
	}
	
	public void run() {
		while(!juego.getGameOver()) {
			time++;
		}
	}

}
