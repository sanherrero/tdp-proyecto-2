package game;

public class Timer implements Runnable {

	private double time;
	private Logica juego;
	private Snake serpiente;
	//constructor para el tiempo del juego
	public Timer(Logica s) {
		juego = s;
		time = 0;
	}
	//constructor para el tiempo de la snake
	public Timer(Snake s) {
		serpiente=s;
		time=0;
	}
	
	public void run() {
		while(!juego.getGameOver()) {
			time++;
		}
	}
	
	public double getTiempo() {
		return time;
	}
	
}
