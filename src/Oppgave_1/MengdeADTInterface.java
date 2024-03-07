package Oppgave_1;

public interface MengdeADTInterface <T> {

	
	boolean isEmpty();
	
	boolean contains(T element);
	
	//Delmengde
	boolean subSetOf(MengdeADTInterface <T> mengde);
	
	boolean equalsSet(MengdeADTInterface <T> mengde);
	
	// finne om mengden er totalt ulike, altså ingen like elementer.
	boolean disjointSet(MengdeADTInterface <T> mengde);
	
	// finne snitt, altså felles elementer og returnere en ny liste.
	MengdeADTInterface <T> intersection (MengdeADTInterface <T> mengde);
	
	//returnere en mengde med mangda a pluss mengde b uten duplikater.
	MengdeADTInterface <T> union (MengdeADTInterface <T> mengde);
	
	//returner en mengde med mengde a minus mengde b.
	MengdeADTInterface <T> differential (MengdeADTInterface <T> mengde);
	
	
	/**
	 * Legger til et element i mengden. Elementet skal kun legges til hvis
	 * det ikke finnes i mengden fra før.
	 * 
	 * @param element
	 */
	void add (T newEntry);
	
	void remove(T element);
	
	int antElementer();
	
	T getElement(int i);
	
	int length();

	boolean isInitialized();
	
	
	
	
	
	
}
