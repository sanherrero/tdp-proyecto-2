package score;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Ranking {

	private String ruta ="src/score/archivo.txt";
	public Ranking() {
		File archivo = new File(ruta);
		if (!archivo.exists()) {
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	};

	public void escribirArchivo(int puntos, String tiempo, String nombre) {
		boolean archivo = false;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(ruta));
			archivo = br.readLine()==null;
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(ruta, true);

			BufferedWriter bfwriter = new BufferedWriter(fileWriter);
			if (!archivo) 
				bfwriter.newLine();

			bfwriter.write(puntos+" "+tiempo+" "+nombre);
			bfwriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

	public void ordenarLista() {

		ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();
		try {
			File archivo = new File(ruta);
			BufferedReader br = new BufferedReader(new FileReader(ruta));
			String string;

			while ((string = br.readLine()) != null) {
				//divido cada linea del archivo en puntos, tiempo y nombre. Parseo puntos y tiempo a enteros
				String[] dividoString = string.split(" ");
				String puntos = dividoString[0]; 
				String tiempo = dividoString[1]; 
				String nombre = dividoString[2];
				String[] parts = tiempo.split(":");
				String tiempoParte1 = parts[0];
				String tiempoParte2 = parts[1];
				String tiempoSinDosPuntos = tiempoParte1+tiempoParte2;
				int time = Math.abs(Integer.parseInt(tiempoSinDosPuntos)-100000);
				String puntajeParaOrdenar = puntos+""+time; //convierto tiempo y puntos a un solo numero para poder ordenar
				int puntosOrdenar = Integer.parseInt(puntajeParaOrdenar);//puntos con los que voy a ordenar la lista
				int puntosJugador = Integer.parseInt(puntos); //puntos que voy a pasar al archivo
				Jugador j = new Jugador(puntosOrdenar, puntosJugador, tiempo, nombre);
				listaJugadores.add(j);
			}
				sortRanking(listaJugadores);
				br.close();
				archivo.delete();
				archivo.createNewFile();

			} catch (Exception e) {
				e.printStackTrace();
			}	
			escribirArchivoSalida(listaJugadores);

		}
		private void escribirArchivoSalida(ArrayList<Jugador>lj) {

			FileWriter fileWriter = null;
			try {
				fileWriter = new FileWriter(ruta, true);
				PrintWriter pw = new PrintWriter(fileWriter);
				int puntos = 0;
				String tiempo = "";
				String nombre = "";
				 for (int i = 0; i <lj.size()&&i<5; i++) {
					 
					puntos = lj.get(i).getPuntosJugador();
					tiempo = lj.get(i).getTiempo();
					nombre = lj.get(i).getNombre();
					pw.print(puntos+" "+tiempo+" "+nombre);
					if(i != lj.size()-1&&i<4)
						pw.println("");
				}
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		private void sortRanking(ArrayList<Jugador> listaJugadores) {
			int size = listaJugadores.size();
			Jugador temp = null;
			//ordeno por puntos
			for (int i = 0; i<size;i++) {
				for (int j = 1; j < size-i; j++) {
					if (listaJugadores.get(j-1).getPuntos() < listaJugadores.get(j).getPuntos()) {
						temp = listaJugadores.get(j-1);
						listaJugadores.set(j-1, listaJugadores.get(j));
						listaJugadores.set(j, temp);
					}
				}
			}
		}
		
		public String[] getTopFive() {
			String[] salida = new String [5];
			try {
				BufferedReader br = new BufferedReader(new FileReader(ruta));
				String lineaTxt = br.readLine();
				for(int i =0; i<5 && lineaTxt!=null;i++) {
					salida[i] = lineaTxt;
					lineaTxt = br.readLine();
				}
				
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return salida;
		}
	}