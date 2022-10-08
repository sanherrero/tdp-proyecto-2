package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import game.Logica;
import game.Snake;

public class GUI extends JFrame {

	private static int height;
	private static int width;
	private static JLabel[][] tablero;
	private static Snake snake;
	private static JLabel lbl_tiempo;
	private static JLabel lbl_puntos;
	private static Logica miJuego;

	public GUI() {
		initialize();
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
		panelDer.setBounds(width, 0, 200, height);
		getContentPane().add(panelDer);
		panelDer.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(40, 140, 120, 120);
		panelDer.add(panel);
		panel.setLayout(null);
		
		tablero = new JLabel[20][20];
		for(int i=0; i<20; i++) {
			for(int j=0; j<20; j++) {
				tablero[i][j] = new JLabel();
				tablero[i][j].setHorizontalAlignment(SwingConstants.CENTER);
				tablero[i][j].setBounds(j*30, i*30, 30, 30);
				panelIzq.add(tablero[i][j]);
			}		
		}							
	}
	
	public void actualizar(int i, int j, ImageIcon nuevaImg){
        tablero[i][j].setIcon(new ImageIcon (nuevaImg.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
    }
	
	public void actualizarPuntuacion(int p) {
		lbl_puntos.setText(Integer.toString(p));
	}
	
	public void actualizarTiempo(int tiempo) {
		lbl_tiempo.setText(Integer.toString(tiempo));
	}
	
	public void gameOver() {
		JOptionPane.showMessageDialog(null, "Game Over");
	}
}
