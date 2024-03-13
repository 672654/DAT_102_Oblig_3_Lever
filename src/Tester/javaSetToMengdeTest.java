package Tester;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Oppgave_1.JavaSetToMengde;
import Oppgave_1.MengdeADTInterface;

class javaSetToMengdeTest {

	MengdeADTInterface<Integer> set1;
	MengdeADTInterface<Integer> set2;
	MengdeADTInterface<Integer> set3;
	
	@BeforeEach
	void setUp() throws Exception {
		this.set1 = new JavaSetToMengde<Integer>();
		this.set2 = new JavaSetToMengde<Integer>();
		this.set3 = new JavaSetToMengde<Integer>();
	}

	@Test
	void testJavaSetToMengde() {
		MengdeADTInterface<String> testConstructor = new JavaSetToMengde<String>();
		assertEquals(0,testConstructor.antElementer());
		assertTrue(testConstructor.isInitialized());
	}

	@Test
	void testIsEmpty() {
		assertTrue(set1.isEmpty());
		set1.add(2);
		assertFalse(set1.isEmpty());
		
	}

	@Test
	void testContains() {
		set1.add(2);
		assertFalse(set1.contains(1));
		assertTrue(set1.contains(2));
		
	}

	@Test
	void testSubSetOf() {
		set1.add(1);
		set1.add(2);
		
		set2.add(1);
		set2.add(2);
		set2.add(3);
		
		assertTrue(set1.subSetOf(set2));
		assertFalse(set2.subSetOf(set1));
		
	}

	@Test
	void testEqualsSet() {
		set1.add(1);
		set1.add(2);
		
		set2.add(1);
		set2.add(2);
		
		set3.add(2);
		
		assertTrue(set1.equalsSet(set2));
		assertFalse(set1.equalsSet(set3));
	}

	@Test
	void testDisjointSet() {
		set1.add(1);
		set1.add(2);
		
		set2.add(3);
		set2.add(4);
		
		set3.add(2);
		
		MengdeADTInterface <Integer> set4 = new JavaSetToMengde<Integer>();
		
		assertTrue(set1.disjointSet(set2));
		assertFalse(set1.disjointSet(set3));
		
		assertTrue(set1.disjointSet(set4));
		assertTrue(set2.disjointSet(set3));
		
	}

	@Test
	void testIntersection() {
		set1.add(1);
		set1.add(2);
		set1.add(3);
		
		set2.add(2);
		set2.add(3);
		set2.add(4);
		
		MengdeADTInterface<Integer> snitt = set1.intersection(set2);
		assertEquals(2,snitt.antElementer());
		assertTrue(snitt.contains(2));
		assertTrue(snitt.contains(3));
		assertFalse(snitt.contains(1));
		assertFalse(snitt.contains(4));

	}

	@Test
	void testUnion() {
		set1.add(1);
		set1.add(2);
		set1.add(3);
		
		set2.add(2);
		set2.add(3);
		set2.add(4);
		
		MengdeADTInterface<Integer> union = set1.union(set2);
		assertEquals(4,union.antElementer());
		assertTrue(union.contains(1));
		assertTrue(union.contains(2));
		assertTrue(union.contains(3));
		assertTrue(union.contains(4));
		
	}

	@Test
	void testDifferential() {
		set1.add(1);
		set1.add(2);
		set1.add(3);
		
		set2.add(2);
		set2.add(3);
		set2.add(4);
		
		MengdeADTInterface<Integer> diff = set1.differential(set2);
		assertEquals(1,diff.antElementer());
		assertFalse(diff.contains(2));
		assertTrue(diff.contains(1));
		
	}

	@Test
	void testAdd() {
		assertEquals(0,set1.antElementer());
		set1.add(2);
		assertEquals(1,set1.antElementer());
		set1.add(2);
		assertEquals(1,set1.antElementer());
		set1.add(3);
		assertEquals(2,set1.antElementer());
		
		assertTrue(set1.contains(2));
		assertTrue(set1.contains(3));
	}

	@Test
	void testRemove() {
		set1.add(2);
		set1.add(3);
		
		assertTrue(set1.contains(3));
		assertEquals(2, set1.antElementer());
		
		set1.remove(3);
		assertFalse(set1.contains(3));
		assertEquals(1,set1.antElementer());
		
		set1.remove(6);
		set1.remove(4);
		assertTrue(set1.contains(2));
		assertEquals(1,set1.antElementer());
		
		set1.remove(2);
		assertFalse(set1.contains(2));
		assertEquals(0,set1.antElementer());
		
		
	}

	@Test
	void testAntElementer() {
		assertEquals(0,set1.antElementer());
		
		set1.add(2);
		set1.add(3);
		
		assertEquals(2,set1.antElementer());
	}

	@Test
	void testGetElement() {
		set1.add(1);
		set1.add(2);
		set1.add(3);
		
		assertTrue(set1.contains(set1.getElement(0)));
		assertTrue(set1.contains(set1.getElement(1)));
		assertTrue(set1.contains(set1.getElement(2)));
		assertFalse(set1.contains(set1.getElement(3)),
				"Skal returnere null dersom parameterinput >= ant.elementer, dvs this.length");
	}

	@Test
	void testLength() {
		assertEquals(0,set1.length());
		set1.add(1);
		assertEquals(1, set1.length());
	}

	@Test
	void testIsInitialized() {
		assertTrue(set1.isInitialized());
	}

	@Test
	void testToArray() {
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.add(4);
		
		Object[] arr = set1.toArray();
		assertEquals(4, arr.length);
	
	}

}
