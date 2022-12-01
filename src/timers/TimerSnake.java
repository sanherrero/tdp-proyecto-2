package timers;

import logica.Logica;
import logica.Snake;

public class TimerSnake extends Thread {
	private boolean run=true;
	
	public TimerSnake() {
	}
	
	public void run() {
		while(run) {
			Logica.getLogica().moverSnake();
			try {
				sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void pararRun() {
		this.run = false;
	}

	public boolean getRun() {
		return run;
	}
}