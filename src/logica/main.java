package logica;

import gui.GUI;

public class main {
	public static void main(String [] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Logica l = logica.Logica.getLogica();
            }
        });
    }
}