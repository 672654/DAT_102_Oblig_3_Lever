package Tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Oppgave_1.LenketMengde;
import Oppgave_1.MengdeADTInterface;

class lenketMengdeTest {

	MengdeADTInterface<Integer> set1;
	MengdeADTInterface<Integer> set2;
	MengdeADTInterface<Integer> set3;
	
	
	@BeforeEach
	void setUp() throws Exception {
		set1 = new LenketMengde<Integer>();
		set2 = new LenketMengde<Integer>();
		set3 = new LenketMengde<Integer>();
	}

	@Test
	void testLenketMengde() {
		MengdeADTInterface<Character> testConstructor = new LenketMengde<Character>();
		
		assertTrue(testConstructor.isInitialized());
		assertEquals(0,testConstructor.antElementer());
		
	}
	@Test
	void testIsEmpty() {
		assertTrue(set1.isEmpty());
		assertEquals(0,set1.antElementer());
		assertEquals(true, set1.isInitialized());
	}

	@Test
	void testContains() {
		assertFalse(set1.contains(1));
		set1.add(2);
		set1.add(4);
		assertEquals(true,set1.contains(2));
		assertEquals(true,set1.contains(4));
		
		
	}

	@Test
	void testSubSetOf() {
		set1.add(2);
		set1.add(4);
		set2.add(2);
		assertEquals(true,set2.subSetOf(set1));
	}

	@Test
	void testEqualsSet() {
		set1.add(2);
		set1.add(4);
		set2.add(2);
		set2.add(4);
		set3.add(2);
		assertTrue(set1.equalsSet(set2));
		assertFalse(set1.equalsSet(set3));
	}

	@Test
	void testDisjointSet() {
		set1.add(2);
		set1.add(4);
		set2.add(2);
		set2.add(4);
		set3.add(3);
		set3.add(5);
		assertFalse(set1.disjointSet(set2));
		assertTrue(set1.disjointSet(set3));
		
	}

	@Test
	void testIntersection() {
		set1.add(2);
		set1.add(4);
		set1.add(5);
		
		set2.add(2);
		set2.add(4);
		set2.add(6);
		
		MengdeADTInterface<Integer> snitt = set1.intersection(set2);
		
		assertTrue(snitt.contains(2));
		assertTrue(snitt.contains(4));
		assertFalse(snitt.contains(6));
		assertFalse(snitt.contains(5));
		assertEquals(2,snitt.antElementer());
		
		
	}

	@Test
	void testUnion() {
		set1.add(2);
		set1.add(4);
		set1.add(6);
		
		set2.add(2);
		set2.add(6);
		set2.add(8);
		
		MengdeADTInterface<Integer> union = set1.union(set2);
		
		assertTrue(union.contains(2));
		assertTrue(union.contains(6));
		assertTrue(union.contains(4));
		assertTrue(union.contains(8));
		
		assertEquals(4,union.antElementer());
	}

	@Test
	void testDifferential() {
		set1.add(2);
		set1.add(4);
		set1.add(6);
		
		set2.add(1);
		set2.add(4);
		set2.add(8);
		//2,4,6 - 1,4,8 = 2,6
		
		MengdeADTInterface<Integer> diff = set1.differential(set2);
		
		assertTrue(diff.contains(2));
		assertTrue(diff.contains(6));
		assertFalse(diff.contains(4));
		assertFalse(diff.contains(8));
		assertFalse(diff.contains(1));
		
		assertEquals(2,diff.antElementer());
		
		
	}

	@Test
	void testAdd() {
		set1.add(2);
		assertEquals(1,set1.antElementer());
		set1.add(4);
		assertEquals(2,set1.antElementer());
		
	}

	@Test
	void testRemove() {
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set1.add(5);
		set1.remove(3);
		assertEquals(4, set1.antElementer());
		assertFalse(set1.contains(3));
		assertTrue(set1.contains(2));
		assertTrue(set1.contains(4));
		set1.remove(1);
		assertFalse(set1.contains(1));
		assertTrue(set1.contains(2));
		set1.remove(5);
		assertFalse(set1.contains(5));
	}

	@Test
	void testAntElementer() {
		assertEquals(0,set1.antElementer());
		set1.add(1);
		assertEquals(1,set1.antElementer());
		set1.add(2);
		assertEquals(2,set1.antElementer());
	}

	@Test
	void testGetElement() {
		set1.add(99);
		set1.add(55);
		assertEquals(99,set1.getElement(1));
		assertEquals(55,set1.getElement(0));
		assertEquals(null, set1.getElement(3));
	}

	@Test
	void testLength() {
		set1.add(2);
		assertEquals(1,set1.length());
		set1.add(2);
		assertEquals(1,set1.length());
		set1.add(4);
		assertEquals(2,set1.length());
	}

	@Test
	void testIsInitialized() {
		MengdeADTInterface<String> node = new LenketMengde<String>();
		assertTrue(node.isInitialized());
		
	}
	
	@Test
	void testToArray() {
		set1.add(1);
		set1.add(2);
		set1.add(3);
		Object[] arr = set1.toArray();
		assertEquals(3, arr.length);
	}

}
