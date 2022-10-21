package game;



public class TimerSnake extends Thread {

	private Snake snake;

	
	
	public TimerSnake(Snake s) {
		
		snake=s;
		
	}
	
	
	
	public void run() {
		while(true) {
			snake.mover();
			try {
				sleep(400);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	
	
}
