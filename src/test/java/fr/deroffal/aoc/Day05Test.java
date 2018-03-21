package fr.deroffal.aoc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class Day05Test {

	/**
	 * (0) 3  0  1  -3
	 */
	@Test
	void cas1_doitJusteIncrementer() {
		final List<Integer> instructions = new ArrayList<>(Arrays.asList(0, 3, 0, 1, -3));

		assertEquals(0, Day05.getNextPosition(instructions, 0, i-> 1));

		assertEquals(1, instructions.get(0).intValue());

		assertEquals(3, instructions.get(1).intValue());
		assertEquals(0, instructions.get(2).intValue());
		assertEquals(1, instructions.get(3).intValue());
		assertEquals(-3, instructions.get(4).intValue());
	}

	/**
	 * (1) 3  0  1  -3
	 */
	@Test
	void cas2_doitIncrementer_et_deplacer() {
		final List<Integer> instructions = new ArrayList<>(Arrays.asList(1, 3, 0, 1, -3));

		assertEquals(1, Day05.getNextPosition(instructions, 0, i-> 1));

		assertEquals(2, instructions.get(0).intValue());

		assertEquals(3, instructions.get(1).intValue());
		assertEquals(0, instructions.get(2).intValue());
		assertEquals(1, instructions.get(3).intValue());
		assertEquals(-3, instructions.get(4).intValue());
	}

	/**
	 * 2 (3) 0  1  -3
	 */
	@Test
	void cas3_doitIncrementer_et_deplacer() {
		final List<Integer> instructions = new ArrayList<>(Arrays.asList(2, 3, 0, 1, -3));

		assertEquals(4, Day05.getNextPosition(instructions, 1, i-> 1));

		assertEquals(2, instructions.get(0).intValue());

		assertEquals(4, instructions.get(1).intValue());
		assertEquals(0, instructions.get(2).intValue());
		assertEquals(1, instructions.get(3).intValue());
		assertEquals(-3, instructions.get(4).intValue());
	}

	/**
	 * 2 3 0  1  (-3)
	 */
	@Test
	void cas4_doitIncrementer_et_deplacer_enArriere() {
		final List<Integer> instructions = new ArrayList<>(Arrays.asList(2, 4, 0, 1, -3));

		assertEquals(1, Day05.getNextPosition(instructions, 4, i-> 1));

		assertEquals(2, instructions.get(0).intValue());

		assertEquals(4, instructions.get(1).intValue());
		assertEquals(0, instructions.get(2).intValue());
		assertEquals(1, instructions.get(3).intValue());
		assertEquals(-2, instructions.get(4).intValue());
	}

	/**
	 * 2 (4) 0  1  -2
	 */
	@Test
	void cas5_doitIncrementer_et_deplacer_enArriere() {
		final List<Integer> instructions = new ArrayList<>(Arrays.asList(2, 4, 0, 1, -2));

		assertEquals(5, Day05.getNextPosition(instructions, 1, i-> 1));

		assertEquals(2, instructions.get(0).intValue());

		assertEquals(5, instructions.get(1).intValue());
		assertEquals(0, instructions.get(2).intValue());
		assertEquals(1, instructions.get(3).intValue());
		assertEquals(-2, instructions.get(4).intValue());
	}

	/**
	 * Test de l'exemple pour le niveau 1.
	 */
	@Test
	void _0_3_0_1_m3_doitRetourner_5(){
		final List<Integer> instructions = new ArrayList<>(Arrays.asList(0, 3, 0, 1, -3));
		assertEquals(5, Day05.countStepToEscape(instructions, i-> 1));
	}

	/**
	 * Test de l'exemple pour le niveau 2.
	 */
	@Test
	void _0_3_0_1_m3_doitRetourner_10(){
		final List<Integer> instructions = new ArrayList<>(Arrays.asList(0, 3, 0, 1, -3));
		assertEquals(10, Day05.countStepToEscape(instructions,  i -> i>= 3 ? -1 : 1));
	}
}