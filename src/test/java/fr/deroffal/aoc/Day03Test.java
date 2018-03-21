package fr.deroffal.aoc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Day03Test {

	@Test
	void input_1_doit_retourner_0() {
		assertEquals(0, Day03.part1(1));
	}

	@Test
	void input_12_doit_retourner_3() {
		assertEquals(3, Day03.part1(12));
	}

	@Test
	void input_23_doit_retourner_2() {
		assertEquals(2, Day03.part1(23));
	}

	@Test
	void input_1024_doit_retourner_31() {
		assertEquals(31, Day03.part1(1024));
	}

	@Test
	void input_361527_doit_retourner_326() {
		assertEquals(326, Day03.part1(361527));
	}

}