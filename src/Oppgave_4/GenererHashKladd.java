package Oppgave_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class GenererHashKladd {

	public static void main(String[] args) {
		// tabell med plass til 1_000_000 elementer av integers.
		ArrayList<Integer> intArr = new ArrayList<Integer>();
		HashSet<Integer> intHash = new HashSet<Integer>();
		int tall = 13;
		for (int i = 0; i < 1_000_000; i++) {
			intArr.add(tall);
			intHash.add(tall);
			tall = (tall + 45713) % 1_000_000;
		}
		long start = 0;
		intArr.sort(null);

		Random random = new Random(1);
		int find = random.nextInt(100);
		int iterations = 100_000;
		int funnet = 0;
		Object[] array = intArr.toArray();

		int[] rand = new int[iterations];
		for (int i = 0; i < iterations; i++) {
			rand[i] = find;
			find = random.nextInt(1, 1_000_000);
		}

		start = System.nanoTime();
		for (int i = 0; i < iterations; i++) {
			if (Arrays.binarySearch(array, rand[i]) >= 0) {
				funnet++;
			}
		}
		System.out.println("Binary Search brukte: " + (System.nanoTime() - start) / 1_000_000 + "ms \ntil og finne "
				+ iterations + " elementer");
		System.out.println("fant " + funnet + " elementer");
		System.out.println();

		funnet = 0;
		start = System.nanoTime();
		for (int i = 0; i < iterations; i++) {
			if (intHash.contains(rand[i])) {
				funnet++;
			}
		}
		System.out.println("HashSet brukte: " + (System.nanoTime() - start) / 1_000_000 + "ms \ntil og finne "
				+ iterations + " elementer");
		System.out.println("fant " + funnet + " elementer");
	}
}
