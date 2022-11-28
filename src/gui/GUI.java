package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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

import logica.Logica;
import score.Jugador;
import score.Ranking;
import timers.*;

import javax.swing.JTextPane;

public class GUI extends JFrame {

	private static int height;
	private static int width;
	private static JLabel[][] tableroLbl;
	private static BloqueGrafico[][] tableroBloqueG;
	private static JLabel lbl_tiempo;
	private static JLabel lbl_puntos;
	private static JLabel lbl_nivelactual;
	private static TimerGui timerTiempo;
	private static TimerSnake timerSerpiente;
	private Thread hiloMovSnake;
	private Thread hiloTiempo;
	private static Oyente teclado;
	private Ranking ranking;

	protected static JLabel lbltexto_top1, lbltexto_top2, lbltexto_top3, lbltexto_top4, lbltexto_top5;
	private static GUI miGUI;
	private static JPanel panelIzq,panel,panelDer;
	
	

	private GUI() {
		initialize();

	}

	public static GUI getGUI() {
		if (miGUI == null)
			miGUI = new GUI();
		return miGUI;
	}

	private void initialize() {

		width = 600;
		height = 600;

		getContentPane().setLayout(null);
		getContentPane().setBounds(0, 0, width + 200, 900);

		Dimension test = new Dimension(width + 200, height + 35);
		setResizable(false);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setPreferredSize(test);
		pack();

		iniciarPaneles();
		iniciarLabels();
		setLblTop5();
		iniciarTableros();
		
		
		teclado = new Oyente();

		this.addKeyListener(teclado);

	}
	
	private void iniciarPaneles() {
		panelIzq = new JPanel();
		panelIzq.setForeground(Color.BLACK);
		panelIzq.setBackground(Color.BLACK);
		panelIzq.setBounds(0, 0, width, height);

		getContentPane().add(panelIzq);
		panelIzq.setLayout(null);

		panelDer = new JPanel();
		panelDer.setBounds(600, 0, 184, 600);
		getContentPane().add(panelDer);
		panelDer.setLayout(null);

		panel = new JPanel();
		panel.setBounds(10, 140, 164, 288);
		// Ranking r = new Ranking(panel);
		panelDer.add(panel);
		panel.setLayout(null);

		
	}
	
	private void iniciarLabels() {
		JLabel lblNewLabel_2 = new JLabel("TOP 5");
		lblNewLabel_2.setBounds(6, 135, 48, 19);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel("TOP 1");
		lblNewLabel_4.setBounds(8, 45, 46, 14);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("TOP 2");
		lblNewLabel_5.setBounds(8, 70, 46, 14);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("TOP 3");
		lblNewLabel_6.setBounds(6, 95, 46, 14);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("TOP 4");
		lblNewLabel_7.setBounds(6, 119, 46, 14);
		panel.add(lblNewLabel_7);
		
		
		

		lbltexto_top1 = new JLabel("New label");
		lbltexto_top1.setBounds(47, 45, 107, 14);
		
		panel.add(lbltexto_top1);

		lbltexto_top2 = new JLabel("New label");
		lbltexto_top2.setBounds(47, 70, 107, 14);
		
		panel.add(lbltexto_top2);

		lbltexto_top3 = new JLabel("New label");
		lbltexto_top3.setBounds(47, 95, 107, 14);
		
		panel.add(lbltexto_top3);

		lbltexto_top4 = new JLabel("New label");
		lbltexto_top4.setBounds(47, 119, 107, 14);
		
		panel.add(lbltexto_top4);

		lbltexto_top5 = new JLabel("New label");
		lbltexto_top5.setBounds(47, 137, 107, 14);
		
		panel.add(lbltexto_top5);
		
		

		JLabel lblNewLabel_8 = new JLabel("PUNTOS");
		lblNewLabel_8.setBounds(47, 20, 51, 14);
		panel.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("NOMBRE");
		lblNewLabel_9.setBounds(108, 20, 56, 14);
		panel.add(lblNewLabel_9);

		

		
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

		JLabel lblNewLabel_3 = new JLabel("NIVEL ACTUAL");
		lblNewLabel_3.setBounds(57, 86, 90, 14);
		panelDer.add(lblNewLabel_3);

		lbl_nivelactual = new JLabel("New label");
		lbl_nivelactual.setBounds(83, 103, 46, 14);
		panelDer.add(lbl_nivelactual);
	}
	
	private void iniciarTableros() {
		tableroLbl = new JLabel[20][20];
		tableroBloqueG = new BloqueGrafico[20][20];
		
		for(int i =0;i<20;i++) {
			for(int j =19;j>=0;j--) {
				JLabel l = new JLabel();
				l.setBounds(i*30, j *30, 30, 30);
				tableroLbl[i][j] = l;
				panelIzq.add(l);
				
			}
		}
		
		
		
	}
	
	public void setLblTop5() {
		ranking = new Ranking();
		String[] top5 =ranking.getTopFive();
		
		System.out.println(top5[0]);
		lbltexto_top1.setText(top5[0]);
		lbltexto_top2.setText(top5[1]);
		lbltexto_top3.setText(top5[2]);
		lbltexto_top4.setText(top5[3]);
		lbltexto_top5.setText(top5[4]);
		repaint();
	}

	private void actualizarPuntos(int puntaje) {
		lbl_puntos.setText("" + puntaje);

	}

	public void setTableroBloquesG(BloqueGrafico[][] tablero) {
		tableroBloqueG = tablero;
	}

	

	public void actualizarPuntuacion(int p) {
		lbl_puntos.setText(Integer.toString(p));
	}

	public JLabel Tiempo() {
		return lbl_tiempo;
	}

	public void gameOver(boolean gane, int score) {

		String userName;
		if (gane) {
			userName = JOptionPane.showInputDialog(null, "You win! Insert your name:");
		} else {
			userName = JOptionPane.showInputDialog(null, "You lost! Insert your name:");
		}

		lbl_tiempo.setText("0:0:0");
		setNivelActual(0);

		actualizarPuntos(Logica.getLogica().getPuntos());
		stopHilos();
		teclado.setIniciarHilos();
		ranking.escribirArchivo(score, timerTiempo.getTiempo(), userName);
		ranking.ordenarLista();
		setLblTop5();
		JOptionPane.showMessageDialog(null, "Congratulations " + userName + ".\nYou scored " + score + " points.");
	}

	public void setNivelActual(int i) {
		lbl_nivelactual.setText("" + i);
	}

	private void startHilos() {
		timerTiempo = new TimerGui(this);
		hiloTiempo = new Thread(timerTiempo);
		hiloTiempo.start();

		timerSerpiente = new TimerSnake();
		hiloMovSnake = new Thread(timerSerpiente);
		hiloMovSnake.start();
	}

	public void stopHilos() {

		timerTiempo.pararRun();
		timerSerpiente.pararRun();
		teclado.setIniciarHilos();

	}

	public void addBloqueGrafico(BloqueGrafico b) {
		tableroLbl[b.getX()][b.getY()].setIcon(b.getImagen());
		repaint();
		
	}

	private class Oyente implements KeyListener {
		boolean iniciarHilos = true;

		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (iniciarHilos) {
				iniciarHilos = false;
				startHilos();
			}
			if (e.getKeyChar() == 'w' || e.getKeyChar() == 'W' || e.getExtendedKeyCode() == KeyEvent.VK_UP) {

				Logica.getLogica().cambiarDireccionSnake(0);

			}
			if (e.getKeyChar() == 's' || e.getKeyChar() == 'S' || e.getExtendedKeyCode() == KeyEvent.VK_DOWN) {
				Logica.getLogica().cambiarDireccionSnake(1);

			}
			if (e.getKeyChar() == 'a' || e.getKeyChar() == 'A' || e.getExtendedKeyCode() == KeyEvent.VK_LEFT) {
				Logica.getLogica().cambiarDireccionSnake(2);

			}
			if (e.getKeyChar() == 'd' || e.getKeyChar() == 'D' || e.getExtendedKeyCode() == KeyEvent.VK_RIGHT) {
				Logica.getLogica().cambiarDireccionSnake(3);

			}

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		public void setIniciarHilos() {
			iniciarHilos = true;
		}

	}

	public void siguienteNivel(int i) {
	
		JOptionPane.showMessageDialog(null, "Pasaste de nivel!");
		GUI.getGUI().stopHilos();
		teclado.setIniciarHilos();
		lbl_tiempo.setText("0:0:0");
		lbl_nivelactual.setText(""+i);
		repaint();
		

	}

	
}