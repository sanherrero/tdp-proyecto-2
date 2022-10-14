package game;

public class Timer implements Runnable {

	private double time, tiempoTranscurrido;
	
	
	public Timer() {
		ponerACero();
	}
	
	private void ponerACero() {
		time=System.currentTimeMillis();
		tiempoTranscurrido=0;
	}
	
	public void run() {
		while(true) {
			tiempoTranscurrido= (System.currentTimeMillis()-time)/1000;
		}
	}
	
	public double getTiempo() {
		return tiempoTranscurrido;
	}
	
}
