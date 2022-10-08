package game;

import TDAQueue.*;

public class LevelGenerator {

	protected int nivActual;
	
	public LevelGenerator() {
		nivActual = -1;
	}
	
	public void cargarNivel(Queue<Alimento> a, Queue<PowerUp> pu, Entity[][] t) {
		nivActual++;
	}
}
