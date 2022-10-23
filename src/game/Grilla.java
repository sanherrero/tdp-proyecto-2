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
		miGenerador = new LevelGenerator();
		Queue<Bloque> posSnake = miGenerador.cargarNivel(nivelActual,alimentos, powerups, tablero);
		nivelActual++;
		
		miJuego = l;
		
		serpiente = new Snake(posSnake,miJuego,this);
		
		
		for(ParteCuerpoSnake i : serpiente.getCuerpo()) {
			tablero[i.getX()][i.getY()] = i;
		}
		agregarPickUpAleatorio();
		
		
	}
	
	
	
	
	public Snake getSnake() {
		return this.serpiente;
	}
	
	public void siguienteNivel() {
		Queue<Bloque> posSnake = miGenerador.cargarNivel(nivelActual,alimentos, powerups, tablero);
		nivelActual++;
		serpiente = new Snake(posSnake,miJuego,this);
		for(ParteCuerpoSnake i : serpiente.getCuerpo()) {
			tablero[i.getX()][i.getY()] = i;
		}
		agregarPickUpAleatorio();
		miJuego.siguienteNivel();
	}
	
	public void gameOver() {
		nivelActual=0;
		Queue<Bloque> posSnake = miGenerador.cargarNivel(nivelActual,alimentos, powerups, tablero);
		nivelActual++;
		int scoreAux = serpiente.getPuntaje();
		serpiente = new Snake(posSnake,miJuego,this);
		for(ParteCuerpoSnake i : serpiente.getCuerpo()) {
			tablero[i.getX()][i.getY()] = i;
		}
		agregarPickUpAleatorio();
		miJuego.gameOver(scoreAux);
	}
	
	public void checkColitions() {
		
		int posXCabeza = serpiente.getCabeza().getX();
		int posYCabeza = serpiente.getCabeza().getY();
		
		tablero[posXCabeza][posYCabeza].action(serpiente);
	}
	
	public Entity[][] getTablero(){
		return tablero;
		
	}
	
	private void buscarPosAleatoriaParaSnake() {
		
	}
	
	public void actualizar() {
		miJuego.actualizar();
	}
	
	public void eliminarColaDelTablero(ParteCuerpoSnake cola) {
		tablero[cola.getX()][cola.getY()] = new Bloque(cola.getX(),cola.getY());
	}
	
	public void actualizarPosSnake() {
		checkColitions();
		
		tablero[serpiente.getCabeza().getX()][serpiente.getCabeza().getY()] = serpiente.getCabeza();
		tablero[serpiente.getCuerpo(1).getX()][serpiente.getCuerpo(1).getY()] = serpiente.getCuerpo(1);
		
		actualizar();
	}
	
	public void agregarPickUpAleatorio() {
		
		int numRandom = (int)(Math.random()*2);
		
			try {
				if(!alimentos.isEmpty() && !powerups.isEmpty()) {
					if(numRandom == 0) {
						buscarLugar(alimentos.dequeue());
					}else {
						buscarLugar(powerups.dequeue());
					}
				
				}else {
					if(alimentos.isEmpty() && powerups.isEmpty())
						this.siguienteNivel();
					else {
						if(!alimentos.isEmpty() && powerups.isEmpty())
							buscarLugar(alimentos.dequeue());
						if(alimentos.isEmpty() && !powerups.isEmpty())
							buscarLugar(powerups.dequeue());
					}
					
					
				}
				
					
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		
	}
	
	private void terminoNivel() {
		System.out.println("termino nivel");
		
	}

	private void buscarLugar(Entity pickUp) {
		
		boolean hayLugar = false;
		
		while(hayLugar == false) {
			int posXRandom = (int)(Math.random()*19);
			int posYRandom = (int)(Math.random()*19);
			hayLugar= tablero[posXRandom][posYRandom].hayEspacio();
			
			if(hayLugar) {
				tablero[posXRandom][posYRandom] = pickUp;
				pickUp.setX(posXRandom);
				pickUp.setY(posYRandom);
			}
				
		}
		
	}
	

}
