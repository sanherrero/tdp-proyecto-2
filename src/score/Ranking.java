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


import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Ranking {
	//private Grilla grilla;

	//private Logica logica;
	private String ruta = "./src/score/ranking.txt";
	private JLabel[] labels;

	

	public Ranking(JLabel[] l) {
		labels =l;
		File archivo = new File(ruta);
		if (!archivo.exists()) {
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		actualizarLabels();

	}
	
	private void actualizarLabels() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(ruta));
			for(int i =0; i<5;i++) {
				String lineaActual = br.readLine();
				labels[i].setText(lineaActual);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
	}
	public void guardarPuntuacion(String nombre, String puntos) {		
		boolean archivo = false;
		try {
			BufferedReader br = new BufferedReader(new FileReader(ruta)); 
			if (br.readLine() == null)
			    archivo = true;
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		FileWriter fileWriter = null;		
		
		try {
			fileWriter = new FileWriter(ruta, true);
			BufferedWriter bfwriter = new BufferedWriter(fileWriter);
			if (!archivo)
				bfwriter.newLine();
			bfwriter.write(puntos+" "+nombre);
			bfwriter.close();
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
		
		getPuntuacion();
		actualizarLabels();
	}

	@SuppressWarnings("unused")
	private void getPuntuacion(){
		File archivo = new File(ruta);
		Scanner scanner;
		String[][] toReturn = null;
		String parts[];
		String nombre;
		int puntaje = 0;
		Player p ;
		ArrayList<Player> ranking = new ArrayList<Player>();
		int size = ranking.size();
		try {
			scanner = new Scanner(archivo);
			while(scanner.hasNextLine()) {
				
				
				parts = scanner.nextLine().split(" ");
				puntaje = Integer.parseInt(parts[0]);
				nombre = parts[1];
				p = new Player(puntaje,nombre);
				
				
				ranking.add(p);
				System.out.println("agregue"+p.getNombre()+" "+p.getPuntaje());
			}
			System.out.println("imprimo lista no ordenada");
			for(Player i: ranking) {
				System.out.println("Pos"+i+" "+i.getNombre()+" "+i.getPuntaje());
			}
			sortRanking(ranking);
			
			scanner.close();
			
			archivo.delete();
			System.out.println(archivo);
			archivo.createNewFile();
			
			FileWriter fileWriter = new FileWriter(ruta, true);
			BufferedWriter bfwriter = new BufferedWriter(fileWriter);
			for(Player i : ranking) {
				
				
			
				bfwriter.newLine();
				bfwriter.write(i.getPuntaje()+" "+i.getNombre());
				
			}
			bfwriter.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}
	private void sortRanking(ArrayList<Player> lista) {
		int size = lista.size();
		
		for(int i =0; i<size;i++) {
			for(int j =1; j<size;j++) {
				if(lista.get(i).getPuntaje()>lista.get(j).getPuntaje()) {
					Player playerAux = lista.get(i);
					lista.set(i,lista.get(j));
					lista.set(j, playerAux);
				}
			}
		}
	}	
}