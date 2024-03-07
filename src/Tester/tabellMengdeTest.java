package Tester;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Oppgave_1.MengdeADTInterface;
import Oppgave_1.TabellMengde;

class tabellMengdeTest {

	MengdeADTInterface<Integer> set1;
	MengdeADTInterface<Integer> set2;
	MengdeADTInterface<Integer> set3;

	@BeforeEach
	void setUp() throws Exception {
		this.set1 = new TabellMengde<Integer>();
		this.set2 = new TabellMengde<Integer>();
		this.set3 = new TabellMengde<Integer>();
		set1.add(2);
		set1.add(4);
		set1.add(6);

		set2.add(2);
		set2.add(4);
		set2.add(6);
		set2.add(8);

	}

	@Test
	void testTabellMengde() {
		MengdeADTInterface<String> constructor = new TabellMengde<String>();
		assertEquals(10,constructor.length());
		assertEquals(0,constructor.antElementer());
		assertEquals(null,constructor.getElement(0));
		assertEquals(true, constructor.isInitialized());
	}

	@Test
	void testIsEmpty() {
		assertTrue(set3.isEmpty(), "Skal være tom");
		assertFalse(set1.isEmpty(), "Skal være false");
	}

	@Test
	void testContains() {
		assertTrue(set1.contains(2));
		assertTrue(set1.contains(4));
		assertTrue(set1.contains(6));
		assertFalse(set1.contains(8));
	}

	@Test
	void testSubSetOf() {
		assertTrue(set1.subSetOf(set2));
		assertFalse(set2.subSetOf(set1));
	}

	@Test
	void testEqualsSet() {

		assertFalse(set1.equalsSet(set2));
		set2.remove(8);
		assertTrue(set1.equalsSet(set2));
	}

	@Test
	void testDisjointSet() {
		set3.add(1);
		set3.add(3);
		set3.add(5);
		set3.add(9);
		assertTrue(set3.disjointSet(set1));
		assertFalse(set1.disjointSet(set2));
	}

	@Test
	void testIntersection() {
		MengdeADTInterface<Integer> forventet = new TabellMengde<Integer>();
		forventet.add(2);
		forventet.add(4);
		forventet.add(6);
		MengdeADTInterface<Integer> snitt = set1.intersection(set2);
		assertEquals(forventet.contains(2), snitt.contains(2));
		assertEquals(forventet.contains(4), snitt.contains(4));
		assertEquals(forventet.contains(6), snitt.contains(6));
	}

	@Test
	void testUnion() {
		// set1: 2 4 6
		// set2: 2 4 6 8
		MengdeADTInterface<Integer> union = set3.union(set1);
		MengdeADTInterface<Integer> union1 = set1.union(set3);
		set3.add(1);
		set3.add(3);
		set3.add(4);
		
		MengdeADTInterface<Integer> union2 = set1.union(set3);
		MengdeADTInterface<Integer> expected = new TabellMengde<Integer>();
		expected.add(1);
		expected.add(2);
		expected.add(3);
		expected.add(4);
		expected.add(6);

		assertEquals(expected.contains(1), union2.contains(1));
		assertEquals(expected.contains(2), union2.contains(2));
		assertEquals(expected.contains(3), union2.contains(3));
		assertEquals(expected.contains(4), union2.contains(4));
		assertEquals(expected.contains(6), union2.contains(6));
		assertEquals(5,union2.antElementer(),"Skal ikke legge til flere av samme element");

	}

	@Test
	void testDifferential() {
		// set1: 2 4 6
		// set2: 2 4 6 8
		// set3: 1 3 4
		set3.add(1);
		set3.add(3);
		set3.add(4);

		MengdeADTInterface<Integer> expected = new TabellMengde<Integer>();
		MengdeADTInterface<Integer> diff = set2.differential(set1);
		MengdeADTInterface<Integer> diff2 = set3.differential(set1);

		expected.add(8);
		assertEquals(expected.contains(8), diff.contains(8));

		expected.remove(8);
		expected.add(1);
		expected.add(3);
		assertEquals(expected.contains(1), diff2.contains(1));
		assertEquals(expected.contains(3), diff2.contains(3));
		assertNotEquals(set3.contains(4),diff2.contains(4));

	}

	@Test
	void testAdd() {
		set3.add(1);
		assertEquals(1, set3.antElementer());
		set3.add(2);
		assertEquals(2, set3.antElementer());
		set3.add(2);
		assertEquals(2, set3.antElementer());
	}

	@Test
	void testRemove() {

		// set1 = 2,4,6
		// set2 = 2,4,6,8
		assertTrue(set2.contains(2));
		set2.remove(8);
		assertFalse(set2.contains(8));

		assertEquals(set2.contains(2), set1.contains(2));
		assertEquals(set2.contains(4), set1.contains(4));
		assertEquals(set2.contains(6), set1.contains(6));

	}

}
