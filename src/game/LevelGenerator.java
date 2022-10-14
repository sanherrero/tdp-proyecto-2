package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import TDAQueue.*;

public class LevelGenerator {

	protected int nivActual;
	protected String[] niveles = {"src/niveles/lvl0.txt", "src/niveles/lvl1.txt", "src/niveles/lvl2.txt", "src/niveles/lvl3.txt", "src/niveles/lvl4.txt"};
	
	
	public LevelGenerator() {
		nivActual = -1;
	}
public void cargarNivel(int lvl,Queue<Alimento> a, Queue<PowerUp> pu, Entity[][] t) {
	File txt_nivel = new File(niveles[lvl]);
	
	try {
		BufferedReader txt = new BufferedReader(new FileReader(txt_nivel));
		for(int i=0; i<20;i++) {
			String linea = txt.readLine();
			for (int j = 0; j <linea.length (); j++){
				if(linea.charAt (j) == 'X') {
					t[i][j] = new Pared();
        			t[i][j].setX(i);
        			t[i][j].setY(j);
				}else {
					t[i][j] = new Bloque(i,j);
        			
					
				}				
				}
		}
		String lineaAlimentos = txt.readLine();
		for (int j = 0; j <lineaAlimentos.length (); j++) {
			if(lineaAlimentos.charAt(j)=='0')
				a.enqueue(new Alimento0());
			
			if(lineaAlimentos.charAt(j)=='1')
				a.enqueue(new Alimento1());
			
			if(lineaAlimentos.charAt(j)=='2')
				a.enqueue(new Alimento2());
			
			if(lineaAlimentos.charAt(j)=='3')
				a.enqueue(new Alimento3());
			
			if(lineaAlimentos.charAt(j)=='4')
				a.enqueue(new Alimento4());
		}
		
		String lineaPowerup = txt.readLine();
		for (int j = 0; j <lineaPowerup.length (); j++) {
			if(lineaPowerup.charAt(j)=='0')
				pu.enqueue(new PowerUp0());
			
			if(lineaPowerup.charAt(j)=='1')
				pu.enqueue(new PowerUp1());
			
			if(lineaPowerup.charAt(j)=='2')
				pu.enqueue(new PowerUp2());
		}
		
		
		txt.close();
		
	} catch (IOException e) {
		e.printStackTrace();
	}
		
		
	}
	
	
}
