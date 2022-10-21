package game;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import TDAQueue.EmptyQueueException;
import TDAQueue.Queue;
import graphics.SnakeGrafica;

public class Snake {
	
	protected SnakeGrafica textura;
	protected Logica miJuego;
	protected Grilla miGrilla;
	protected int tamActual;
	
	protected int x;
	protected int y;
	protected TimerGui cronometroSnake;
	protected int tiempoS;
	protected int puntaje;
	protected ParteCuerpoSnake cabeza;
	protected List<ParteCuerpoSnake> listaCuerpo;
	protected int colorSnake = 0; // atributo para describir el color de la snake en el momento 0->default, 1->green, 2->pink y 3->red
	protected int direccion = 2;  // atributo para describir la direccion de la snake en el momento 0->arriba, 1->abajo, 2->izquierda y 3->derecha
	protected String[] cabezaDefault = {"src/textures/hd/head-top-default.png", "src/textures/hd/head-bottom-default.png","src/textures/hd/head-left-default.png","src/textures/hd/head-right-default.png"};
	protected String[] cabezaGreen = {"src/textures/hg/head-top-green.png", "src/textures/hg/head-bottom-green.png","src/textures/hg/head-left-green.png","src/textures/hg/head-right-green.png"};
	protected String[] cabezaPink = {"src/textures/hp/head-top-pink.png", "src/textures/hp/head-bottom-pink.png","src/textures/hp/head-left-pink.png","src/textures/hp/head-right-pink.png"};
	protected String[] cabezaRed = {"src/textures/hr/head-top-red.png", "src/textures/hr/head-bottom-red.png","src/textures/hr/head-left-red.png","src/textures/hr/head-right-red.png"};
	
	public Snake() {}
	public Snake(Queue<Bloque> posiciones,Logica j, Grilla g) {
		listaCuerpo = new ArrayList<ParteCuerpoSnake>();
		while(!posiciones.isEmpty()) {
			ParteCuerpoSnake parteNueva = new ParteCuerpoSnake();
			Bloque pos;
			try {
				pos = posiciones.dequeue();
				parteNueva.setX(pos.getX());
				parteNueva.setY(pos.getY());
				listaCuerpo.add(parteNueva);
			} catch (EmptyQueueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		crearCabeza(listaCuerpo.get(0));
		
		miGrilla = g;
		textura = new SnakeGrafica();
		miJuego = j;
		tamActual = 3;
		
		puntaje = 0;
		tiempoS=0;
		tiempo();
	}
	
	public void aumentarTam(int cant) {
		tamActual+=cant;
	}
	
	public void sumarPuntos(int cant) {		
		puntaje+=cant;
		
	}
	
	public int getPuntaje() {
		return puntaje;	
	}
	
	/**
	 * Se pasa el movimiento actual para ver qué textura usar.
	 * 0 = up
	 * 1 = right
	 * 2 = down
	 * 3 = left
	 */
	
	
	
	public void chocar() {
		miJuego.setGameOver();
	}
	
	//Pasa al checkColotions las coordenadas del bloque que va a chocar.
	
	
	public void cambiarDefefault() {
		colorSnake = 0;
		for(ParteCuerpoSnake i : listaCuerpo) {
			i.cambiarColor(colorSnake);
		}
		cambiarImagenCabeza();
	}
	public void cambiarVerde() {
		colorSnake = 1;
		for(ParteCuerpoSnake i : listaCuerpo) {
			i.cambiarColor(colorSnake);
		}
		cambiarImagenCabeza();
	}
	public void cambiarRosa() {
		colorSnake = 2;
		for(ParteCuerpoSnake i : listaCuerpo) {
			i.cambiarColor(colorSnake);
		}
		cambiarImagenCabeza();
	}
	public void cambiarRojo() {
		colorSnake = 3;
		for(ParteCuerpoSnake i : listaCuerpo) {
			i.cambiarColor(colorSnake);
		}
		cambiarImagenCabeza( );
	}
	
	
	public void cambiarDireccion(int d) {
		if(!(d ==0 && direccion == 1)&&!(d ==1 && direccion == 0)&&!(d ==2 && direccion == 3)&&!(d ==3 && direccion == 2))
			direccion = d;
	}
	public void mover() {
		if(direccion == 0)
			moverArriba();
		if(direccion == 1)
			moverAbajo();
		if(direccion == 2)
			moverIzquierda();
		if(direccion == 3)
			moverDerecha();
	}
	public void moverDerecha() {
		if(direccion !=2) {
			direccion = 3;
			cambiarImagenCabeza();
			ParteCuerpoSnake cola = listaCuerpo.remove(listaCuerpo.size() - 1);
			ParteCuerpoSnake parteAux = new ParteCuerpoSnake();
			parteAux.cambiarColor(colorSnake);
			parteAux.setY(cabeza.getY());
			parteAux.setX(cabeza.getX());
			listaCuerpo.add(1,parteAux);
			cabeza.setY(cabeza.getY() + 1);
			miGrilla.actualizarPosSnake(cola);
			
		}
	}
	
	public void moverIzquierda() {
		if(direccion !=3) {
			direccion = 2;
			cambiarImagenCabeza();
			ParteCuerpoSnake cola = listaCuerpo.remove(listaCuerpo.size() - 1);
			ParteCuerpoSnake parteAux = new ParteCuerpoSnake();
			parteAux.cambiarColor(colorSnake);
			parteAux.setY(cabeza.getY());
			parteAux.setX(cabeza.getX());
			listaCuerpo.add(1,parteAux);
			cabeza.setY(cabeza.getY() - 1);
			miGrilla.actualizarPosSnake(cola);
			
		}
		
	}

	
	public void moverAbajo() {
		if(direccion !=0) {
			direccion = 1;
			cambiarImagenCabeza();
			ParteCuerpoSnake cola = listaCuerpo.remove(listaCuerpo.size() - 1);
			ParteCuerpoSnake parteAux = new ParteCuerpoSnake();
			parteAux.cambiarColor(colorSnake);
			parteAux.setY(cabeza.getY());
			parteAux.setX(cabeza.getX());
			listaCuerpo.add(1,parteAux);
			cabeza.setX(cabeza.getX() + 1);
			
			miGrilla.actualizarPosSnake(cola);
			
		}
	}
	
	public void moverArriba() {
		if(direccion !=1) {
			direccion = 0;
			cambiarImagenCabeza();
			ParteCuerpoSnake cola = listaCuerpo.remove(listaCuerpo.size() - 1);
			ParteCuerpoSnake parteAux = new ParteCuerpoSnake();
			parteAux.cambiarColor(colorSnake);
			parteAux.setY(cabeza.getY());
			parteAux.setX(cabeza.getX());
			listaCuerpo.add(1,parteAux);
			cabeza.setX(cabeza.getX() - 1);
			miGrilla.actualizarPosSnake(cola);
			
		}
	}
	
	public void gameOver() {
		miJuego.setGameOver();
	}
	
	public int getMovimientoActual() {
		return direccion;
	}
	//hilo de ejecucion del tiempo de la snake
	private void tiempo() {
		cronometroSnake= new TimerGui(this,0.5);
		Thread d= new Thread(cronometroSnake);
		d.start();	
	}
	public int getTiempo() {
		return tiempoS;
	}
	public void setTiempo(int t) {
		tiempoS=t;
	}
	private void crearCabeza(ParteCuerpoSnake c) {
		cabeza = c;
		cabeza.setImagen( new ImageIcon(cabezaDefault[direccion]));
		
	}
	public List<ParteCuerpoSnake> getCuerpo(){
		return listaCuerpo;
	}
	
	private void cambiarImagenCabeza() {
		if(colorSnake == 0) {
			cabeza.setImagen(new ImageIcon(cabezaDefault[direccion]));
		}
		if(colorSnake == 1) {
			cabeza.setImagen(new ImageIcon(cabezaGreen[direccion]));
		}
		if(colorSnake == 2) {
			cabeza.setImagen(new ImageIcon(cabezaPink[direccion]));
		}
		if(colorSnake == 3) {
			cabeza.setImagen(new ImageIcon(cabezaRed[direccion]));
		}
		
	}
	
	
	
}
