package game;

import java.awt.EventQueue;
import gui.GUI;

public class mainSnake {

	public static void main(String[] args) {
		
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					GUI frame = new GUI();
					frame.setVisible(true);
					frame.setFocusable(true);
				    Logica snake = new Logica(frame);
				    Timer r = new Timer(snake);
				    Thread d= new Thread(r);
					d.start();	
					
				} });
			
	}
}