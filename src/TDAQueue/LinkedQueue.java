package TDAQueue;

public class LinkedQueue<E> implements Queue<E> {
	
	protected Nodo<E> head,tail;
	protected int size;
	
	public LinkedQueue() {
		head = new Nodo<E>();
		tail= new Nodo<E>();
		size=0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size==0;
	}

	public E front() throws EmptyQueueException {
		if(isEmpty()) {
			throw new EmptyQueueException("Cola vacia");
		}
		return head.getElement();
	}

	public void enqueue(E element) {
		Nodo<E> nuevo = new Nodo<E>(element);
		if(isEmpty()) {
			head=nuevo;
			tail=head;
		} else {
			tail.setSiguiente(nuevo);
			tail=tail.getSiguiente();  
		}
		size++;
	}

	public E dequeue() throws EmptyQueueException {
		if(isEmpty()) {
			throw new EmptyQueueException("Cola vacia");
		}
		E aux = head.getElement();
		head= head.getSiguiente();
		size--;
		return aux;
	}

}