package Oppgave_1;

public class Person {
	private String navn;
	private String[] hobbyer;
	
	public Person(String navn, String...hobbyer) {
		this.navn = navn;
		this.hobbyer = hobbyer;
	}
	
	public String[] getHobbyer() {
		return hobbyer;
	}
}
