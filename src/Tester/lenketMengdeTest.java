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
		fail("Not yet implemented");
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
		fail("Not yet implemented");
	}

	@Test
	void testDisjointSet() {
		fail("Not yet implemented");
	}

	@Test
	void testIntersection() {
		fail("Not yet implemented");
	}

	@Test
	void testUnion() {
		fail("Not yet implemented");
	}

	@Test
	void testDifferential() {
		fail("Not yet implemented");
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
//		fail("Not yet implemented");
	}

	@Test
	void testAntElementer() {
		fail("Not yet implemented");
	}

	@Test
	void testGetElement() {
		fail("Not yet implemented");
	}

	@Test
	void testLength() {
		fail("Not yet implemented");
	}

	@Test
	void testIsInitialized() {
		fail("Not yet implemented");
	}

}
