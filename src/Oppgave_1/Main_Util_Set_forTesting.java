package Oppgave_1;

import java.util.HashSet;

public class Main_Util_Set_forTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MengdeADTInterface<Integer> mengde = new JavaSetToMengde<Integer>();
		MengdeADTInterface<Integer> annenMengde = new JavaSetToMengde<Integer>();

		mengde.add(2);
		mengde.add(4);

		annenMengde.add(2);
		annenMengde.add(3);

		MengdeADTInterface<Integer> diff = mengde.differential(annenMengde);
		MengdeADTInterface<Integer> union = mengde.union(annenMengde);
		
		
		System.out.println(union.getElement(0));
		System.out.println(union.getElement(1));
		System.out.println(union.getElement(2));
		
		System.out.println();
		
		Object[] arr = union.toArray();
		for (Object i: arr) {
			System.out.println(i);
			
		}
		


		// 1,2,3

		// 2,3,4
		//
		//
		//

	}

}
