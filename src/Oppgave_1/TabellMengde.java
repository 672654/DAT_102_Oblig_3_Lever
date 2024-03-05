package Oppgave_1;

import java.util.Arrays;
import java.util.Objects;

public class TabellMengde<T> implements MengdeADTInterface<T> {

	private T[] mengde;
	private int numberOfElements;
	private Integer DEFAULT_CAPACITY = 10;
	private final Integer MAX_CAPACITY = 10000;
	private boolean initialized;

	@SuppressWarnings("unchecked")
	public TabellMengde() {
		this.mengde = (T[]) new Object[DEFAULT_CAPACITY];
		this.numberOfElements = 0;
		this.initialized = true;
	}

	@Override
	public boolean isEmpty() {
		return (numberOfElements == 0);

	}

	@Override

	public boolean contains(T element) {
		if (isEmpty()) {
			return false;
		}

		for (int i = 0; i < numberOfElements; i++) {
			if (mengde[i].equals(element)) {
				return true;
			}
		}
		return false;
	}

	// Delmengde
	@Override
	public boolean subSetOf(MengdeADTInterface<T> set) {

		for (int i = 0; i < numberOfElements; i++) {
			if (!set.contains(mengde[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean equalsSet(MengdeADTInterface<T> set) {
		if(set.antElementer() != this.antElementer()){
			return false;
		}
	
		for (int i = 0; i < numberOfElements; i++) {
			if (!set.contains(mengde[i])) {
				return false;
			}	
		}
		return true;

	}

	@Override
	public boolean disjointSet(MengdeADTInterface<T> set) {
		for (int i = 0; i < numberOfElements; i++) {
			if (set.contains(mengde[i])) {
				return false;
			}	
		}
		return true;
	}

	//returner en mengde som er delt mellom begge mengdene
	@Override
	public MengdeADTInterface<T> intersection(MengdeADTInterface<T> set) {
		
		if(set.isEmpty()|| isEmpty()) {
			return null;
		}
		MengdeADTInterface<T> snitt = new TabellMengde<T>();
		
		for(int i = 0; i < numberOfElements; i++) {
			if(set.contains(mengde[i])) {
				snitt.add(mengde[i]);
				
			}
		}
		return snitt;
	}

	@Override
	public MengdeADTInterface<T> union(MengdeADTInterface<T> set) {
		
		if (set.isEmpty() && isEmpty()) {
			return null;
		}
		MengdeADTInterface<T> union = new TabellMengde<T>();
		
		if (set.isEmpty()) {
			for(T e: mengde) {
				union.add(e);
			}
			return union;
		}
		
		if (isEmpty()) {
			for(int i = 0; i < set.antElementer(); i++) {
				
				union.add();
			}
			return union;
		}
		
		
		
		return null;
	}

	@Override
	public MengdeADTInterface<T> differential(MengdeADTInterface<T> set) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(T newEntry) {
		if (numberOfElements >= mengde.length) {
			return;
		}
		if (!contains(newEntry)) {
			mengde[numberOfElements] = newEntry;
			numberOfElements++;
		}

	}

	@Override
	public void remove(T element) {

		if (!contains(element) || isEmpty()) {
			return;
		}
		int indexFjernet = 0;

		for (int i = 0; i < mengde.length; i++) {
			T elementIndex = mengde[i];
			if (elementIndex.equals(element)) {
				indexFjernet = i;
				fjernOgSorter(indexFjernet);
				return;
			}
		}

	}

	private void fjernOgSorter(int indexFjernet) {
		for (int i = indexFjernet; i < numberOfElements - 1; i++) {
			mengde[i] = mengde[i + 1];
		}
		mengde[numberOfElements] = null;
		numberOfElements--;
	}

	public int antElementer() {
		return numberOfElements;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(mengde);
		result = prime * result + Objects.hash(DEFAULT_CAPACITY, MAX_CAPACITY, initialized, numberOfElements);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("unchecked")
		TabellMengde<T> other = (TabellMengde<T>) obj;
		return Objects.equals(DEFAULT_CAPACITY, other.DEFAULT_CAPACITY)
				&& Objects.equals(MAX_CAPACITY, other.MAX_CAPACITY) && initialized == other.initialized
				&& Arrays.deepEquals(mengde, other.mengde) && numberOfElements == other.numberOfElements;
	}

}
