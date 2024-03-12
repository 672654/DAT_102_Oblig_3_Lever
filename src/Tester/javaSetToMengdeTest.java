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
		fail("Not yet implemented");
	}

	@Test
	void testIsEmpty() {
		fail("Not yet implemented");
	}

	@Test
	void testContains() {
		fail("Not yet implemented");
	}

	@Test
	void testSubSetOf() {
		fail("Not yet implemented");
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
		fail("Not yet implemented");
	}

	@Test
	void testRemove() {
		fail("Not yet implemented");
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

	@Test
	void testToArray() {
		fail("Not yet implemented");
	}

}
