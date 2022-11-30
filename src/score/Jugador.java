package score;

public class Jugador {
	
	private int puntosOrdenar;
	private int puntosJugador;
	private String tiempo;
	private String nombre;
	
	public Jugador (int puntosOrdenar, int puntosJugador, String tiempo, String nombre) {
		this.puntosOrdenar = puntosOrdenar;
		this.puntosJugador = puntosJugador;
		this.tiempo = tiempo;
		this.nombre = nombre;
	}
	
	public int getPuntos() {
		return puntosOrdenar;
	}
	
	public String getTiempo() {
		return tiempo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getPuntosJugador() {
		return puntosJugador;
	}
}
