package br.univille.estd.stacks;

public class StackMin<E extends Comparable> implements Stack<E> {
	protected int size; // Tamanho da pilha
	protected Node<E> top; // Referencia para o Nodo cabeça
	protected E min; // Valor mínimo da pilha
	protected Node<E> minAnt;

	public StackMin(){
		size = 0;
		top = null;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public E top() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("Não consta");
		}
		return top.getElement();
	}

	@Override
	public void push(E element) {
		Node<E> v = new Node<E>(element, top);
		top = v;
		size++;
		//((Integer) element).compareTo(Integer.parseInt(min.toString())) < 0
		if (min == null) {
			min = element;
		} else {
			if (element.compareTo(min) <= 0) {
				Node<E> m = new Node<E>(min, minAnt);
				minAnt = m;
				min = element;
			}
		}
	}

	@Override
	public E pop() throws EmptyStackException {
		E e;
		if (isEmpty()) {
			throw new EmptyStackException("Não consta");
		}
	
		e = top.getElement();
		top = top.getNext();
		size -= 1;
		
		if (e.equals(min)) {
			min = minAnt.getElement();
			minAnt = minAnt.getNext();
		}
	
		return e;
	}

	@Override
	public E min() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("Não consta");
		}

		return min;
	}
	
	@Override
	public String toString() {
		String stack = "[ ";
		Node<E> element = top;
		for (int i = 0; i < size(); i++) {
			stack += i == 0 ? element.getElement() : ", " + element.getElement();
			element = element.getNext();
		}
		stack += " ]";
		
		return stack;
	}
}
