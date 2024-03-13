package Oppgave_1;

public class HobbyMatchMain {
	
public static void main(String[] args) {
		Person arne = new Person("Arne", "Guitar", "BIl", "BaT", "Synge", "turgaing");
		Person oliver = new Person("Oliver", "Guitar", "BIl", "BaT", "tag", "slalom", "spill");
		Person henrik = new Person("Henrik", "Piano", "Bil", "tag", "spill");
		Person david = new Person("David", "Guitar", "Sykkel", "BAT", "spill");
		Person[] alle = {arne, oliver, henrik, david};
		
		double best = 0.0;
		Person bestA = null, bestB = null;
		for (int i = 0; i < alle.length; i++) {
			for (int j = i; j < alle.length; j++) {
				if (alle[i].equals(alle[j])) {
					// do nothing.
				} else if (match(alle[i], alle[j]) > best) {
					best = match(alle[i], alle[j]);
					bestA = alle[i];
					bestB = alle[j];
				}
			}
		}
		System.out.println(best);
		System.out.println(bestA);
		System.out.println(bestB);
	}
	
	static double match(Person a, Person b) {
		return antallFelles(a, b) - (antallKunHosDenEne(a, b) + antallKunHosDenEne(b, a)) / antallTotalt(a, b);
	}
	
	static double antallFelles(Person a, Person b) {
		double felles = 0.0;
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
	 static double antallKunHosDenEne(Person a, Person b) {
		double alene = a.getHobbyer().length - antallFelles(a, b);
		return alene;
	}
	
	static double antallTotalt(Person a, Person b) {
		return a.getHobbyer().length + b.getHobbyer().length;
	}
}
