package Oppgave_1;

public class HobbyMatchMain {
	
public static void main(String[] args) {
		Person Arne = new Person("Arne", "Guitar", "BIl", "BaT");
		Person Arne2 = new Person("Arne2", "Guitar", "BIl", "BaT", "bla", "blie");
		Person Henrik = new Person("Henrik", "Piano", "Bil", "baT");
		Person David = new Person("David", "Guitar", "Sykkel", "BAT");
		
		System.out.println(antallFelles(Henrik, Arne));
		System.out.println(antallKunHosDenEne(Arne2, David));
		System.out.println(match(Henrik, David));
		System.out.println(match(Arne, David));
		System.out.println(match(Arne, Arne2));
	}
	
	static double match(Person a, Person b) {
		return antallFelles(a, b) - (antallKunHosDenEne(a, b) + antallKunHosDenEne(b, a)) / antallTotalt(a, b);
	}
	
	static int antallFelles(Person a, Person b) {
		int felles = 0;
		if (a.getHobbyer().length == 0 || b.getHobbyer().length == 0) {
			return felles;
		}
		for (int i = 0; i < a.getHobbyer().length; i++) {
			for (int j = 0; j < b.getHobbyer().length; j++) {
				if (a.getHobbyer()[i].toUpperCase().equals(b.getHobbyer()[j].toUpperCase())) {
					felles++;
				}
			}
		}
		return felles;
	}
	
	/**
	 * Gir antall hobbyer hos kun Person a.
	 * @param a
	 * @param b
	 * @return
	 */
	 static int antallKunHosDenEne(Person a, Person b) {
		int alene = a.getHobbyer().length - antallFelles(a, b);
		return alene;
	}
	
	static int antallTotalt(Person a, Person b) {
		return a.getHobbyer().length + b.getHobbyer().length;
	}
}
