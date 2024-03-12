package Oppgave_1;

import java.util.HashSet;

public class Util_Set {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MengdeADTInterface<Integer> mengde = new JavaSetToMengde<Integer>();
		MengdeADTInterface<Integer> annenMengde = new JavaSetToMengde<Integer>();

		mengde.add(2);
		mengde.add(4);

		annenMengde.add(2);
		annenMengde.add(3);

		MengdeADTInterface<Integer> diff = mengde.differential(annenMengde);
		
		System.out.println(diff.contains(3));

		// 1,2,3

		// 2,3,4
		//
		//
		//

	}

}
