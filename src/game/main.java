package game;



import gui.GUI;

public class main {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Logica l = new Logica();
            	l.getGrilla().getSnake().cambiarRosa();
            	l.actualizar();
            	
            	
            	
            	
            	
            	
            	
            	
            	
            }
        });
    }
}
