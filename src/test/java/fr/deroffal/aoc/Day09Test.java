package fr.deroffal.aoc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class Day09Test {

	@Test
	void removeCanceledCharacters() {
		assertEquals("abc", Day09.removeCanceledCharacters("a!!b!!!!c!"));
	}

	@Test
	void emptyAfterRemovingGarbage() {
		assertTrue(Day09.removeGarbage("<>").isEmpty());
		assertTrue(Day09.removeGarbage("<random characters>").isEmpty());
		assertTrue(Day09.removeGarbage("<<<<>").isEmpty());
		assertTrue(Day09.removeGarbage("<{!>}>").isEmpty());
		assertTrue(Day09.removeGarbage("<!!>").isEmpty());
		assertTrue(Day09.removeGarbage("<!!!>>").isEmpty());
		assertTrue(Day09.removeGarbage("<{o\"i!a,<{i<a>").isEmpty());
	}

	@Test
	void oneGroupAfterRemovingGarbage() {
		assertEquals("{}", Day09.removeGarbage("{<{},{},{{}}>}"));
	}

	/**
	 * {} : 1 group.
	 */
	@Test
	void simple_expect_1() {
		assertEquals(1, Day09.countScore("{}"));
	}

	/**
	 * {{{}}} : 6
	 */
	@Test
	void threeSimple_expect_6() {
		assertEquals(6, Day09.countScore("{{{}}}"));
	}

	/**
	 * {{{}}} : 3 groups.
	 */
	@Test
	void twoInOne_expect_5() {
		assertEquals(5, Day09.countScore("{{},{}}"));
	}

	/**
	 * {<{},{},{{}}>} : 1 group (which itself contains garbage).
	 */
	@Test
	void simpleSelfContainGarbage_expect_1() {
		assertEquals(1, Day09.countScore("{<{},{},{{}}>}"));
	}

	/**
	 * {<a>,<a>,<a>,<a>} : 1 group.
	 */
	@Test
	void manyGarbage_expect_1() {
		assertEquals(1, Day09.countScore("{<a>,<a>,<a>,<a>}"));
	}

	@Test
	void thisExample_expect_16() {
		assertEquals(16, Day09.countScore("{{{},{},{{}}}}"));
	}
}