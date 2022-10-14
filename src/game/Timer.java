package game;

public class Timer implements Runnable {

	private double time, tiempoTranscurrido, reducir;
	
	
	public Timer() {
		ponerACero();
		reducir=1;
	}
	public Timer(double n) {
		ponerACero();
		reducir=n;
	}
	
	private void ponerACero() {
		time=System.currentTimeMillis();
		tiempoTranscurrido=0;
	}
	
	public void run() {
		while(true) {
			tiempoTranscurrido= ((System.currentTimeMillis()-time)/1000)/reducir;
		}
	}
	
	public double getTiempo() {
		return tiempoTranscurrido;
	}
	
}
