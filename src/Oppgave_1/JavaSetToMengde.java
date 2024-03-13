package Oppgave_1;

import java.util.HashSet;
import java.util.Set;

public class JavaSetToMengde<T> implements MengdeADTInterface<T> {

	private Set<T> mengde;
	private int numberOfElements;
	private boolean initialized;

	public JavaSetToMengde() {
		mengde = new HashSet<T>();
		this.numberOfElements = 0;
		this.initialized = true;
	}

	@Override
	public boolean isEmpty() {
		return mengde.isEmpty();
	}

	@Override
	public boolean contains(T element) {
		return mengde.contains(element);

	}

	private HashSet<T> castToSet(MengdeADTInterface<T> annenmengde) {

		Set<T> annenMengde = ((JavaSetToMengde<T>) annenmengde).mengde;
		return (HashSet<T>) annenMengde;

	}

	@Override
	public boolean subSetOf(MengdeADTInterface<T> annenmengde) {

		if (annenmengde instanceof JavaSetToMengde) {
			Set<T> annenMengde = castToSet(annenmengde);
			return annenMengde.containsAll(this.mengde);
		}
		return false;

	}

	@Override
	public boolean equalsSet(MengdeADTInterface<T> annenmengde) {
		if (annenmengde instanceof JavaSetToMengde) {
			Set<T> annenMengde = ((JavaSetToMengde<T>) annenmengde).mengde;
			return this.mengde.equals(annenMengde);
		}
		return false;
	}

	// Totalt ulike
	@Override
	public boolean disjointSet(MengdeADTInterface<T> annenmengde) {
		if (annenmengde.isEmpty()) {
			return true;
		}
		if (annenmengde instanceof JavaSetToMengde) {
			Set<T> annenMengde = ((JavaSetToMengde<T>) annenmengde).mengde;
			@SuppressWarnings("unchecked")
			T[] array = (T[]) annenMengde.toArray();
			for (int i = 0; i < array.length; i++) {
				if (mengde.contains(array[i])) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	// Snitt, felles elementer.
	@Override
	public MengdeADTInterface<T> intersection(MengdeADTInterface<T> annenmengde) {
		MengdeADTInterface<T> result = new JavaSetToMengde<T>();

		if (annenmengde instanceof JavaSetToMengde) {
			Set<T> annenMengde = ((JavaSetToMengde<T>) annenmengde).mengde;
			@SuppressWarnings("unchecked")
			T[] array = (T[]) annenMengde.toArray();

			for (int i = 0; i < array.length; i++) {
				if (mengde.contains(array[i])) {
					result.add(array[i]);
				}
			}
		}
		return result;
	}

	// mengde a pluss mengde b
	@Override
	public MengdeADTInterface<T> union(MengdeADTInterface<T> annenmengde) {

		MengdeADTInterface<T> resultat = new JavaSetToMengde<T>();

		if (annenmengde instanceof JavaSetToMengde) {
			Set<T> annenMengde = ((JavaSetToMengde<T>) annenmengde).mengde;

			@SuppressWarnings("unchecked")
			T[] arraythisMengde = (T[]) this.mengde.toArray();
			@SuppressWarnings("unchecked")
			T[] array = (T[]) annenMengde.toArray();
			
			for (int j = 0; j < arraythisMengde.length; j++) {
				resultat.add(arraythisMengde[j]);
			}
			for (int i = 0; i < array.length; i++) {
				resultat.add(array[i]);
			}
		}
		return resultat;

	}

	// mangde A minus mengde B
	@Override
	public MengdeADTInterface<T> differential(MengdeADTInterface<T> annenmengde) {
		MengdeADTInterface<T> result = new JavaSetToMengde<T>();
		if (annenmengde instanceof JavaSetToMengde) {
			Set<T> annenMengde = ((JavaSetToMengde<T>) annenmengde).mengde;
			@SuppressWarnings("unchecked")
			T[] arraythisMengde = (T[]) this.mengde.toArray();

			for (int i = 0; i < arraythisMengde.length; i++) {
				if (!annenMengde.contains(arraythisMengde[i])) {
					result.add(arraythisMengde[i]);
				}
			}
		}
		return result;
	}

	@Override
	public void add(T newEntry) {
		if(mengde.add(newEntry)) {
		numberOfElements++;
		}

	}

	@Override
	public void remove(T element) {
		if(mengde.remove(element)) {
		numberOfElements--;
		}

	}

	@Override
	public int antElementer() {
		return numberOfElements;
	}

	@Override
	public T getElement(int i) {
		
		@SuppressWarnings("unchecked")
		T[] arraythisMengde = (T[]) this.mengde.toArray();
		if (i >= arraythisMengde.length) {
			return null;
		}
		T element = arraythisMengde[i];
		return element;
	}

	@Override
	public int length() {
		return numberOfElements;
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] arraythisMengde = (T[]) this.mengde.toArray();
		return arraythisMengde;
	}

}
