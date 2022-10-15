package game;

import gui.GUI;

public class Timer implements Runnable {

	private double time, tiempoTranscurrido, reducir;
	private GUI gui;
	private Snake snake;
	int h, m, s;
	
	
	
	public Timer(GUI g) {
		gui=g;
		ponerACero();
		reducir=1;
		h=0;
		m=0;
		s=0;
	}
	public Timer(Snake s,double n) {
		ponerACero();
		snake=s;
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
				s=(int)tiempoTranscurrido;
				if(s>=60) {
					m+=1;
					ponerACero();
					if(m>=60) {
						m=0;
						h+=1;
						ponerACero();
					}
				}
				gui.Tiempo().setText(""+h+":"+m+":"+s);
			}
			else {
				snake.setTiempo((int)tiempoTranscurrido);
			}
			
		}
	}
	
	public double getTiempo() {
		return tiempoTranscurrido;
	}
	
}
