package timers;

import gui.GUI;
import logica.Snake;

public class TimerGui implements Runnable {

	private double time, tiempoTranscurrido, reducir;
	private GUI gui;
	private Snake snake;
	int h, m, s;
	private boolean run = true;

	public TimerGui(GUI g) {
		gui = g;
		ponerACero();
		reducir = 1;
		h = 0;
		m = 0;
		s = 0;
	}

	public TimerGui(Snake s, double n) {
		ponerACero();
		snake = s;
		reducir = n;
	}

	private void ponerACero() {
		time = System.currentTimeMillis();
		tiempoTranscurrido = 0;
	}

	public void run() {
		while (run) {
			tiempoTranscurrido = ((System.currentTimeMillis() - time) / 1000) / reducir;
			if (reducir == 1) {
				s = (int) tiempoTranscurrido;
				if (s >= 60) {
					m += 1;
					ponerACero();
					if (m >= 60) {
						m = 0;
						h += 1;
						ponerACero();
					}
				}
				gui.Tiempo().setText("" + h + ":" + m + ":" + s);
			} else {
				snake.setTiempo((int) tiempoTranscurrido);
			}
		}
	}

	public void pararRun() {
		this.run = false;
	}

	public String getTiempo() {
		String salida = (m + ":" + s);
		if (m < 10) {
			salida = ("0" + m + ":" + s);
		}
		return salida;
	}
}