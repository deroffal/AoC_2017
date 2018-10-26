package fr.deroffal.aoc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class Day06Test {

	@Test
	void redistribute_0270_donne_2412() {
		final List<Integer> in = new ArrayList<>(Arrays.asList(0, 2, 7, 0));
		assertEquals(Arrays.asList(2, 4, 1, 2), Day06.redistribute(in));
	}

	@Test
	void redistribute_2412_donne_3123() {
		final List<Integer> in = new ArrayList<>(Arrays.asList(2, 4, 1, 2));
		assertEquals(Arrays.asList(3, 1, 2, 3), Day06.redistribute(in));
	}

	@Test
	void redistribute_3123_donne_0234() {
		final List<Integer> in = new ArrayList<>(Arrays.asList(3, 1, 2, 3));
		assertEquals(Arrays.asList(0, 2, 3, 4), Day06.redistribute(in));
	}
}