package game;

import gui.GUI;

public class Timer implements Runnable {

	private double time, tiempoTranscurrido, reducir;
	private GUI gui;
	
	
	
	public Timer(GUI g) {
		gui=g;
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
			if(reducir==1) {
				gui.Tiempo().setText(""+(int)tiempoTranscurrido);
			} 
		}
	}
	
	public double getTiempo() {
		return tiempoTranscurrido;
	}
	
}
