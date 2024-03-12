package Oppgave_1;

public class LenketMengde<T> implements MengdeADTInterface<T> {

	private Node<T> startNode;
	private Integer antall;
	private boolean initialized;

	public LenketMengde() {
		this.startNode = new Node<T>();
		this.antall = 0;
		this.initialized = true;
	}

	@Override
	public boolean isEmpty() {
		return this.startNode.getData() == null;
	}

	@Override
	public boolean contains(T element) {
		if (antall < 1) {
			return false;
		}
		Node<T> temp = startNode;
		
		while (temp!=null) {
			if(temp.getData().equals(element)) {
				return true;
			}
			temp = temp.getNext();
		}
		return false;
	}

	@Override
	public boolean subSetOf(MengdeADTInterface<T> mengde) {
		for (int i = 0; i < antall; i++) {
			Node<T> index = startNode;
			for (int j = 0; j < mengde.length(); j++) {
				if (index.getData() == mengde.getElement(j)) {
					return false;
				}
			}
			index = index.getNext();
		}
		return true;
	}

	@Override
	public boolean equalsSet(MengdeADTInterface<T> mengde) {
		if (mengde.antElementer() != antElementer()) {
			return false;
		}
		for (int i = 0; i < antall; i++) {
			if (!mengde.contains(getElement(i))) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean disjointSet(MengdeADTInterface<T> mengde) {
		for (int i = 0; i < antall; i++) {
			if (mengde.contains(getElement(i))) {
				return false;
			}
		}
		return true;
	}

	@Override
	public MengdeADTInterface<T> intersection(MengdeADTInterface<T> mengde) {
		if(mengde.isEmpty() || isEmpty()) {
			return null;
		}
		
		MengdeADTInterface<T> snitt = new TabellMengde<T>();
		for(int i = 0; i < antall; i++) {
			if(mengde.contains(getElement(i))) {
				snitt.add(getElement(i));
			}
		}
		return snitt;
	}

	@Override
	public MengdeADTInterface<T> union(MengdeADTInterface<T> mengde) {
		if (mengde.isEmpty() && isEmpty()) {
			return null;
		}
		MengdeADTInterface<T> union = new TabellMengde<T>();
		
		if (mengde.isEmpty()) {
			for(int i = 0; i < antElementer(); i++) {
				union.add(getElement(i));
			}
			return union;
		}
		
		if (isEmpty()) {
			for(int i = 0; i < mengde.antElementer(); i++) {
				union.add(mengde.getElement(i));
			}
			return union;
		}
		
		for(int i = 0; i < antElementer(); i++) {
			union.add(getElement(i));
		}
		for(int i = 0; i < mengde.antElementer(); i++) {
			union.add(mengde.getElement(i));
		}
		return union;
	}

	@Override
	public MengdeADTInterface<T> differential(MengdeADTInterface<T> mengde) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(T newEntry) {
		if (startNode.getData() == null) {
			startNode.setData(newEntry);
			startNode.setNext(null);
			antall++;
			return;
		}
		Node<T> midlertidig = startNode;

		while (midlertidig.getNext() != null) {
			midlertidig = midlertidig.getNext();
		}
		midlertidig.getNext().setData(newEntry);
		midlertidig.getNext().setNext(null);
		antall++;

	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub

	}

	@Override
	public int antElementer() {
		return antall;
	}

	@Override
	public T getElement(int index) {
		if (antall == 0) {
			return null;
		}
		Node<T> plass = startNode;
		for (int i = 0; i < antall; i++) {
			if (i == index) {
				return plass.getData();
			}
			plass = plass.getNext();
		}
		return null;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return antall;
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	private static class Node<T> {

		public T data;
		public Node<T> next;

		public Node() {
			this.data = null;
			this.next = null;
		}
		
		public Node(T data) {
			this.data = data;
			this.next = null;
		}

		public void setData(T data) {
			this.data = data;
		}

		public T getData() {
			return this.data;
		}

		public void setNext(Node<T> nextNode) {
			this.next = nextNode;
		}

		public Node<T> getNext() {
			return next;
		}
	}

}
