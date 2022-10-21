package score;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

import game.Grilla;
import game.Logica;
import game.Snake;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Ranking extends JFrame{
	//private Grilla grilla;
	private Logica logica;
	private String ruta = "./src/score/ranking.txt";
	private JTextField textField;

	public Ranking() {

		File archivo = new File(ruta);
		if (!archivo.exists()) {
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		setResizable(false);
		setTitle("Nuevo Record");

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Ingrese nombre:");
		lblNewLabel.setBounds(26, 14, 129, 59);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(115, 32, 207, 23);
		panel.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(148, 75, 77, 19);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = textField.getText();
				guardarPuntuacion(nombre);
			}
		});

	}

	public void guardarPuntuacion(String nombre) {		
	
		boolean gameOver = logica.getGameOver();

		FileWriter fileWriter = null;	
		if (gameOver) {


			try {
				fileWriter = new FileWriter(ruta, true);
				BufferedWriter bfwriter = new BufferedWriter(fileWriter);
				bfwriter.newLine();

				bfwriter.write(logica.getPuntos()+" "+nombre);
				bfwriter.close();
				puntuaciones();

			} catch(IOException e) {
				e.printStackTrace();
			} finally {
				if (fileWriter != null) {
					try {
						fileWriter.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} 
	}

	@SuppressWarnings("unused")
	private String[][] puntuaciones(){
		File archivo = new File(ruta);
		Scanner scanner;
		String[][] toReturn = null;
		String parts[];
		String nombre;
		int puntaje = 0;
		Player p = new Player(0, null);
		ArrayList<Player> ranking = new ArrayList<Player>();
		int size = ranking.size();
		try {
			scanner = new Scanner(archivo);
			while(scanner.hasNextLine()) {
				parts = scanner.nextLine().split(" ");
				puntaje = Integer.parseInt(parts[0]);
				nombre = parts[1];
				p.setPuntaje(puntaje);
				p.setNombre(nombre);
				ranking.add(p);
			}
			sortRanking(ranking);
			
			toReturn = new String [size][2];
			for (int i = 0; i<size; i++) {
				parts = ranking.get(i).toString().split(" ");
				toReturn[i][0] = parts[0];
				toReturn[i][1] = parts[1];
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return toReturn;

	}
	private void sortRanking(ArrayList<Player> arreglo) {
		int size = arreglo.size();
		Player pTemp = null;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size - i -1; j++)
			if (arreglo.get(j).getPuntaje() > arreglo.get(j+1).getPuntaje()) {
				pTemp = arreglo.get(j);
				arreglo.set(j, arreglo.get(j+1));
				arreglo.set(j+1, pTemp);
			}
		}
	}	

}