package game;

import TDAQueue.*;

public class LevelGenerator {
	
	protected final String[] alimentos = {"/textures/alimento_1.png", "/textures/alimento_2.png", "/textures/alimento_3.png", "/textures/alimento_4.png", "/textures/alimento_5.png"};
	protected final String[] powerups = {"/textures/powerup_1.png", "/textures/powerup_2.png", "/textures/powerup_3.png", "/textures/powerup_4.png", "/textures/powerup_5.png"};
	protected Grilla miGrilla;
	protected Entity[][] nivel;
	
	public LevelGenerator(Grilla g) {
		miGrilla = g;
	}
	
	public Queue<Alimento> getAlimentos() {
		Queue<Alimento> toReturn = new LinkedQueue<Alimento>(); 
		/**
		 * Leemos el archivo de texto y generamos una cola de alimentos.
		 */
		return toReturn;
	}
	
	public Queue<PowerUp> getPowerUps() {
		Queue<PowerUp> toReturn = new LinkedQueue<PowerUp>(); 
		/**
		 * Leemos el archivo de texto y generamos una cola de powerUps.
		 */
		return toReturn;
	}
	
	private void createNivel(int n) {
		nivel = new Entity[20][20];
		//Se lee el archivo del nivel "n" y se crea el nivel.
	}
	
	public Entity[][] getNivel(int num) {
		createNivel(num);
		return nivel;
	}
}
