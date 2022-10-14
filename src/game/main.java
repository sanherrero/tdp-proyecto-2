package game;



import gui.GUI;

public class main {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	
            	GUI gui = new GUI();
            	gui.setVisible(true);
            	
            	Logica l = new Logica(gui);
            	Grilla g = new Grilla(l);
            	
            	
            	
            	Entity[][] arreglo = g.getTablero();
            
            	for(int y =0 ; y<20;y++) {
            			for(int x =0 ; x<20;x++) {
            				gui.actualizar(x,y, arreglo[x][y].getImagen());
            				
            		}
            	}
            }
        });
    }
}
