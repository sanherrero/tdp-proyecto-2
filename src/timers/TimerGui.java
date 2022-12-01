package timers;

import gui.GUI;
import logica.Snake;

public class TimerGui implements Runnable {

	private double time, tiempoTranscurrido, reducir;

	int h, m, s;
	private boolean run = true;

	public TimerGui() {
		ponerACero();
		reducir = 1;
		h = 0;
		m = 0;
		s = 0;
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
				GUI.getGUI().Tiempo("" + h + ":" + m + ":" + s);
			} else {
			}
		}
	}

	public void pararRun() {
		this.run = false;
	}

	public boolean getRun() {
		return run;
	}
	public int getH() {
		return h;
	}
	public int getM() {
		return m;
	}
	public int getS() {
		return s;
	}

	public String getTiempo() {
		String salida = (m + ":" + s);
		if (m < 10) {
			salida = ("0" + m + ":" + s);
		}
		return salida;
	}
}