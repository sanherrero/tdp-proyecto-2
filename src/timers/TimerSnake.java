package timers;

import logica.Logica;
import logica.Snake;

public class TimerSnake extends Thread {

	private Snake snake;
	private boolean run=true;
	
	public TimerSnake() {
		snake= Logica.getLogica().getGrilla().getSnake();
	}
	
	public void run() {
		while(run) {
			snake.mover();
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
}