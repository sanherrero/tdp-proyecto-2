package game;

import java.util.*;

public class Grilla {
	protected Snake serpiente;
	protected Queue<Pickup> alimentos;
	protected Queue<Pickup> powerups;
	protected Entity[][] tablero;
	protected Logica miJuego;
	
	public Grilla(Logica l) {
		miJuego = l;
		tablero = new Entity[20][20];
	}
	
	public Snake getSnake() {
		return serpiente;
	}
}
