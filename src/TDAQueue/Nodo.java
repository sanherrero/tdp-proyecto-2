package TDAQueue;

public class Nodo<E> {
	private E element;
	private Nodo<E> siguiente;

	public Nodo(E elemento,Nodo<E> sig) {
		element = elemento;
		siguiente = sig;
	}

	public Nodo(E elemento) {
		this(elemento,null);
	}

	public Nodo() {
		this(null,null);	
	}

	public void setElement(E e) {
		element =e;
	}

	public void setSiguiente(Nodo<E> sig) {
		siguiente = sig;
	}

	public E getElement() {
		return element;	
	}

	public Nodo<E> getSiguiente(){
		return siguiente;		
	}

}