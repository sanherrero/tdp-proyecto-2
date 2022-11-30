package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


import gui.BloqueGrafico;


public class LevelGenerator {
	protected String[] niveles = { "src/niveles/lvl0.txt", "src/niveles/lvl1.txt", "src/niveles/lvl2.txt",
			"src/niveles/lvl3.txt", "src/niveles/lvl4.txt" };

	public LevelGenerator() {

	}

	public Queue<Pos> cargarNivel(int lvl, Queue<Integer> alimentos, Queue<Integer> pu, Bloque[][] t) {
		File txt_nivel = new File(niveles[lvl]);

		List<Queue<Pos>> posParaSnake = new ArrayList<Queue<Pos>>();

		try {

			BufferedReader txt = new BufferedReader(new FileReader(txt_nivel));
			for (int i = 0; i < 20; i++) {
				int contAux = 0;
				Queue<Pos> colaAux = new ArrayDeque<Pos>();
				String linea = txt.readLine();
				BloqueGrafico g;
				for (int j = 0; j < linea.length(); j++) {
					if (linea.charAt(j) == 'X') {
						t[i][j] = new Bloque(true,i, j);
						contAux = 0;
						colaAux = new ArrayDeque<Pos>();
					} else {
						t[i][j] = new Bloque(false,i, j);

						colaAux.add(new Pos(i, j));
						contAux++;
						if (contAux == 3) {
							posParaSnake.add(colaAux);
							contAux = 0;
							colaAux = new ArrayDeque<Pos>();
						}

					}
				}
			}
			String lineaAlimentos = txt.readLine();
			for (int j = 0; j < lineaAlimentos.length(); j++) {
				if (lineaAlimentos.charAt(j) == '0')
					alimentos.add(0);

				if (lineaAlimentos.charAt(j) == '1')
					alimentos.add(1);

				if (lineaAlimentos.charAt(j) == '2')
					alimentos.add(2);

				if (lineaAlimentos.charAt(j) == '3')
					alimentos.add(3);

				if (lineaAlimentos.charAt(j) == '4')
					alimentos.add(4);
			}

			String lineaPowerup = txt.readLine();
			for (int j = 0; j < lineaPowerup.length(); j++) {
				if (lineaPowerup.charAt(j) == '0')
					pu.add(0);

				if (lineaPowerup.charAt(j) == '1')
					pu.add(1);

				if (lineaPowerup.charAt(j) == '2')
					pu.add(2);
			}

			txt.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		int numeroRandom = (int) (Math.random() * posParaSnake.size());
		Queue<Pos> salida = posParaSnake.get(numeroRandom);
		return salida;

	}

}
