package fr.deroffal.aoc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

class Day10Test {

	@Test
	void part1() {
		final List<Integer> lengths = Arrays.asList(3, 4, 1, 5);
		final List<Integer> numbers = IntStream.rangeClosed(0, 4).boxed().collect(Collectors.toList());

		assertEquals(12, Day10.getPart1(numbers, lengths));
	}

	/**
	 * [0] 1 2 3 4
	 * length : 3
	 * skip size : 0
	 */
	@Test
	void part1_example_step_1() {
		final List<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4));
		final int nextPos = Day10.reverse(list, 0, 3, 0);
		assertEquals(Arrays.asList(2, 1, 0, 3, 4), list);
		assertEquals(3, nextPos);
	}

	/**
	 * 2 1 0 [3] 4
	 * length : 4
	 * skip size : 1
	 */
	@Test
	void part1_example_step_2() {
		final List<Integer> list = new ArrayList<>(Arrays.asList(2, 1, 0, 3, 4));
		final int nextPos = Day10.reverse(list, 3, 4, 1);
		assertEquals(Arrays.asList(4, 3, 0, 1, 2), list);
		assertEquals(3, nextPos);
	}

	/**
	 * 4 3 0 [1] 2
	 * length : 1
	 * skip size : 2
	 */
	@Test
	void part1_example_step_3() {
		final List<Integer> list = new ArrayList<>(Arrays.asList(4, 3, 0, 1, 2));
		final int nextPos = Day10.reverse(list, 3, 1, 2);
		assertEquals(Arrays.asList(4, 3, 0, 1, 2), list);
		assertEquals(1, nextPos);
	}

}