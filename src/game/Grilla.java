package game;

import TDAQueue.*;

public class Grilla {
	int nivelActual = 0;
	protected Snake serpiente;
	protected Queue<Alimento> alimentos;
	protected Queue<PowerUp> powerups;
	protected Entity[][] tablero;
	protected Logica miJuego;
	protected LevelGenerator miGenerador;
	
	public Grilla(Logica l) {
		tablero = new Entity[20][20];
		alimentos = new LinkedQueue<Alimento>();
		powerups = new LinkedQueue<PowerUp>();
		iniciarTablero();
		miGenerador = new LevelGenerator();
		Queue<Bloque> posSnake = miGenerador.cargarNivel(nivelActual,alimentos, powerups, tablero);
		nivelActual++;
		
		miJuego = l;
		
		serpiente = new Snake(posSnake,miJuego,this);
		
		
		for(ParteCuerpoSnake i : serpiente.getCuerpo()) {
			tablero[i.getX()][i.getY()] = i;
		}
		
		
	}
	
	//Inicia un tablero "standard" con todos bloques de fondo.
	public void iniciarTablero() {
		}
	
	
	public Snake getSnake() {
		return this.serpiente;
	}
	
	public void siguienteNivel() {
		miGenerador.cargarNivel(nivelActual,alimentos, powerups, tablero);
		nivelActual++;
	}
	
	public void checkColitions(int x, int y) {
		tablero[x][y].action(serpiente);
	}
	
	public Entity[][] getTablero(){
		return tablero;
		
	}
	
	private void buscarPosAleatoriaParaSnake() {
		
	}
	
	public void actualizar() {
		
		miJuego.actualizar();
	}
	
	public void actualizarPosSnake(ParteCuerpoSnake cola) {
		tablero[cola.getX()][cola.getY()] = new Bloque(cola.getX(),cola.getY());
		for(ParteCuerpoSnake i : serpiente.getCuerpo()) {
			tablero[i.getX()][i.getY()] = i;
		}
		actualizar();
	}
	

}
