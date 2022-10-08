package game;

import java.io.FileReader;
import java.io.IOException;

import TDAQueue.*;

public class LevelGenerator {

	protected int nivActual;
	protected String[] niveles = {"src/niveles/lvl0.txt", "src/niveles/lvl1.txt", "src/niveles/lvl2.txt", "src/niveles/lvl3.txt", "src/niveles/lvl4.txt"};
	
	
	public LevelGenerator() {
		nivActual = -1;
	}
	
	public void cargarNivel(Queue<Alimento> a, Queue<PowerUp> pu, Entity[][] t) {
		nivActual++;
        FileReader freader;
		try {
			freader = new FileReader(niveles[nivActual]);
			char[] i = new char[600]; //Guarda todos los caracteres del archivo en un array.
	        freader.read(i);
	        int contGeneral = 0; //Contador para saber por qué caracter voy.
	        for(int j=0; j<20; j++) {  //Doble loop para simular la grilla.
	        	for(int k=0; k<21; k++) {
	        		if(i[contGeneral]=='X') { //Si el caracter en la posición (J, K) es una 'X' se crea una pared.
	        			t[k][j] = new Pared();
	        			t[k][j].setX(k);
	        			t[k][j].setY(j);
	        		} else if (i[contGeneral]=='O') { //Si el caracter en la posición (J, K) es una 'O' se crea un bloque de fondo.
	        			t[k][j] = new Bloque();
	        			t[k][j].setX(k);
	        			t[k][j].setY(j);
	        		}
	        		contGeneral++;
	        	}
	        }
	        while(i[contGeneral]!='\n') { //Mientras el caracter no sea un salto de línea, se leen todos los alimentos
	        	switch (i[contGeneral]) {
	        		case 0: a.enqueue(new Alimento0());
	        		case 1: a.enqueue(new Alimento1());
	        		case 2: a.enqueue(new Alimento2());
	        		case 3: a.enqueue(new Alimento3());
	        		case 4: a.enqueue(new Alimento4());
	        	}
	        	contGeneral++;
	        }
	        contGeneral++; //Como el último caracter leído es un salto de línea, le aumento 1 para que sea el primer powerup
	        while(i[contGeneral]!='\n') { //Mientras el caracter no sea un salto de línea, se leen todos los powerups
	        	switch (i[contGeneral]) {
	        		case 0: pu.enqueue(new PowerUp0());
	        		case 1: pu.enqueue(new PowerUp1());
	        		case 2: pu.enqueue(new PowerUp2());
	        	}
	        	contGeneral++;
	        }
	        freader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
