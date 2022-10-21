
package score;

public class Player {
	private int puntaje;
	private String nombre;

	public Player(int puntaje, String nombre) {
		this.puntaje = puntaje;
		this.nombre = nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public String getNombre() {
		return nombre;
	}

}