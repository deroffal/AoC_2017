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

		assertEquals(12, Day10.part1(numbers, lengths));
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

	/**
	 * Conversion ascii + ajout de la constante à la fin
	 */
	@Test
	void conversionAscii() {
		assertEquals(Arrays.asList(49, 44, 50, 44, 51, 17, 31, 73, 47, 23), Day10.getLength("1,2,3"));
	}

	@Test
	void doKnotHash_for_EmptyString() {
		final List<Integer> numbers = IntStream.rangeClosed(0, 255).boxed().collect(Collectors.toList());
		assertEquals("a2582a3a0e66e6e86e3812dcb672a272", Day10.doKnotHash("", numbers));
	}

	@Test
	void doKnotHash_for_otherExample() {
		List<Integer> numbers = IntStream.rangeClosed(0, 255).boxed().collect(Collectors.toList());
		assertEquals("33efeb34ea91902bb2f59c9920caa6cd", Day10.doKnotHash("AoC 2017", numbers));
		numbers = IntStream.rangeClosed(0, 255).boxed().collect(Collectors.toList());
		assertEquals("3efbe78a8d82f29979031a4aa0b16a9d", Day10.doKnotHash("1,2,3", numbers));
		numbers = IntStream.rangeClosed(0, 255).boxed().collect(Collectors.toList());
		assertEquals("63960835bcdc130f0b66d7ff4f6a5a8e", Day10.doKnotHash("1,2,4", numbers));
	}
}