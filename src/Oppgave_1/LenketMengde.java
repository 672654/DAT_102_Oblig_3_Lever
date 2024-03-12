package Oppgave_1;

public class LenketMengde<T> implements MengdeADTInterface<T> {


	private Node<T> startNode;
	private Integer antall;
	private boolean initialized;
	
	
	public LenketMengde () {
		this.startNode = null;
		this.antall = null;
		this.initialized = true;
	}
	
	@Override
	public boolean isEmpty() {
		return this.startNode == null;
	}

	@Override
	public boolean contains(Object element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean subSetOf(MengdeADTInterface mengde) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean equalsSet(MengdeADTInterface mengde) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean disjointSet(MengdeADTInterface mengde) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MengdeADTInterface intersection(MengdeADTInterface mengde) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MengdeADTInterface union(MengdeADTInterface mengde) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MengdeADTInterface differential(MengdeADTInterface mengde) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(T newEntry) {
		if (startNode == null) {
			startNode.setData(newEntry);
			startNode.setNext(null);
			antall++;
			return;
		}
		Node<T> midlertidig = startNode;
		
		while(midlertidig.getNext()!=null) {
			midlertidig = midlertidig.getNext();
		}
		midlertidig.getNext().setData(newEntry);
		midlertidig.getNext().setNext(null);
		antall++;
		
		
		
		
	}

	@Override
	public void remove(Object element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int antElementer() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T getElement(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isInitialized() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
private static class Node <T>{
		
		public T data;
		public Node<T> next;
		
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
		public Node<T> getNext(){
			return next;
		}
	}
	
}
