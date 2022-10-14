package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

import game.Bloque;
import game.Logica;
import game.Pared;
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
