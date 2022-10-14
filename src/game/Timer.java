package game;






public class Timer implements Runnable {

	private double time, tiempoTranscurrido;
	private Logica juego;
	private Snake serpiente;
	//constructor para el tiempo del juego
	/*public Timer(Logica s) {
		juego = s;
		time = 0;
	}
	//constructor para el tiempo de la snake
	public Timer(Snake s) {
		serpiente=s;
		time=0;
	}*/
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
