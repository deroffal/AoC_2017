package fr.deroffal.aoc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Day01Test {

	@Test
	void input1122_offset1_retourne_3() {
		assertEquals(3, Day01.calculerScore("1122", 1));
	}

	@Test
	void input1111_offset1_retourne_4() {
		assertEquals(4, Day01.calculerScore("1111", 1));
	}

	@Test
	void input1234_offset1_retourne_0() {
		assertEquals(0, Day01.calculerScore("1234", 1));
	}

	@Test
	void input91212129_offset1_retourne_9() {
		assertEquals(9, Day01.calculerScore("91212129", 1));
	}

	@Test
	void input1212_offset2_retourne_6() {
		assertEquals(6, Day01.calculerScore("1212", 2));
	}

	@Test
	void input1221_offset2_retourne_0() {
		assertEquals(0, Day01.calculerScore("1221", 2));
	}

	@Test
	void input123425_offset3_retourne_4() {
		assertEquals(4, Day01.calculerScore("123425", 3));
	}

	@Test
	void input123123_offset3_retourne_12() {
		assertEquals(12, Day01.calculerScore("123123", 3));
	}

	@Test
	void input12131415_offset4_retourne_4() {
		assertEquals(4, Day01.calculerScore("12131415", 4));
	}

}
