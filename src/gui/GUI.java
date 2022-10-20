package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import game.Entity;
import game.Logica;
import game.Snake;
import game.Timer;

public class GUI extends JFrame {

	private static int height;
	private static int width;
	private static JLabel[][] tablero;
	private Snake serpiente;
	private static JLabel lbl_tiempo;
	private static JLabel lbl_puntos;
	private static Logica miJuego;
	private static Timer reloj;
	private static Oyente teclado;



	
public GUI(Snake s) {
		this.serpiente = s;
		if(s == null)
			System.out.println("no ma la contes");
		initialize();
		teclado = new Oyente();
		
		this.addKeyListener(teclado);
	}

	private void initialize() {
		width = 600;
		height = 600;

		getContentPane().setLayout(null);
		getContentPane().setBounds(0, 0,width+200, 900);

		Dimension test = new Dimension(width+200,height+35);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setPreferredSize(test);
		pack();

		JPanel panelIzq = new JPanel();
		panelIzq.setBackground(Color.BLACK);
		panelIzq.setBounds(0, 0, width, height);
		getContentPane().add(panelIzq);
		panelIzq.setLayout(new GridLayout(20, 20, 0, 0));

		JPanel panelDer = new JPanel();
		panelDer.setBounds(600, 0, 184, 600);
		getContentPane().add(panelDer);
		panelDer.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(22, 140, 141, 288);
		panelDer.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("TOP 5");

		lblNewLabel_2.setBounds(8, 20, 125, 25);
		panel.add(lblNewLabel_2);

		tablero = new JLabel[20][20];
		for(int i=0; i<20; i++) {
			for(int j=0; j<20; j++) {
				tablero[i][j] = new JLabel();
				tablero[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				tablero[i][j].setBounds(j*30, i*30, 30, 30);
				panelIzq.add(tablero[i][j]);
			}		
		}
		lbl_tiempo = new JLabel();
		lbl_tiempo.setText("00:00");
		lbl_tiempo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tiempo.setBounds(57, 26, 90, 14);
		panelDer.add(lbl_tiempo);

		lbl_puntos = new JLabel();
		lbl_puntos.setText("0");
		lbl_puntos.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_puntos.setBounds(57, 67, 90, 14);
		panelDer.add(lbl_puntos);

		JLabel lblNewLabel = new JLabel("TIEMPO");
		lblNewLabel.setBounds(83, 11, 46, 14);
		panelDer.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("PUNTOS");
		lblNewLabel_1.setBounds(83, 51, 64, 14);
		panelDer.add(lblNewLabel_1);
		Timer t= new Timer(this);
		Thread d = new Thread(t);
		d.start();
		
		
	}
	
	public void actualizar(Entity[][] arreglo) {        
    	for(int y =0 ; y<20;y++) {
    			for(int x =0 ; x<20;x++) {
    				actualizar(x,y, arreglo[x][y].getImagen());
    				System.out.println(arreglo[x][y].getClass()+" posx: "+x+" posy: "+y);
    				
    		}
    	}
	}

	public void actualizar(int i, int j, ImageIcon nuevaImg){

		tablero[i][j].setIcon(new ImageIcon (nuevaImg.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
	}

	public void actualizarPuntuacion(int p) {
		lbl_puntos.setText(Integer.toString(p));
	}

	
	public JLabel Tiempo() {
		//lbl_tiempo.setText(""+ reloj.getTiempo());
		return lbl_tiempo;
	}

	public void gameOver() {
		JOptionPane.showMessageDialog(null, "Game Over");
	}
	public void setSnake(Snake s) {
		serpiente = s;
		
	}
	
	private class Oyente implements KeyListener{
		public void keyTyped(KeyEvent e) {
			if(e.getKeyChar() == 'w' || e.getExtendedKeyCode() == KeyEvent.VK_UP) {

				serpiente.moverArriba();
				System.out.println("arriba");
			}
			if(e.getKeyChar() == 's' || e.getExtendedKeyCode() == KeyEvent.VK_DOWN) {
				serpiente.moverAbajo();
				System.out.println("abajo");
			}
			if(e.getKeyChar() == 'a' || e.getExtendedKeyCode() == KeyEvent.VK_LEFT) {
				serpiente.moverIzquierda();
				System.out.println("izquierda");
			}
			if(e.getKeyChar() == 'd' || e.getExtendedKeyCode() == KeyEvent.VK_RIGHT) {
				serpiente.moverDerecha();
				System.out.println("derecha");
			}
			
			
		}


		

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
