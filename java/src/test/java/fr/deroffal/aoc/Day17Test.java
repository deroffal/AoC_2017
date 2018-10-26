package fr.deroffal.aoc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class Day17Test {

	@Test
	void process_step1() {
		final List<Integer> buffer = Stream.of(0).collect(Collectors.toList());
		final int nextPosition = Day17.process(3, buffer, 1, 0);
		assertEquals(Stream.of(0, 1).collect(Collectors.toList()), buffer);
		assertEquals(1, nextPosition);
	}

	@Test
	void process_step2() {
		final List<Integer> buffer = Stream.of(0, 1).collect(Collectors.toList());
		final int nextPosition = Day17.process(3, buffer, 2, 1);
		assertEquals(Stream.of(0, 2, 1).collect(Collectors.toList()), buffer);
		assertEquals(1, nextPosition);
	}

	@Test
	void process_step3() {
		final List<Integer> buffer = Stream.of(0, 2, 1).collect(Collectors.toList());
		final int nextPosition = Day17.process(3, buffer, 3, 1);
		assertEquals(Stream.of(0, 2, 3, 1).collect(Collectors.toList()), buffer);
		assertEquals(2, nextPosition);
	}

	@Test
	void process_step4() {
		final List<Integer> buffer = Stream.of(0, 2, 3, 1).collect(Collectors.toList());
		final int nextPosition = Day17.process(3, buffer, 4, 2);
		assertEquals(Stream.of(0, 2, 4, 3, 1).collect(Collectors.toList()), buffer);
		assertEquals(2, nextPosition);
	}

	@Test
	void process_step5() {
		final List<Integer> buffer = Stream.of(0, 2, 4, 3, 1).collect(Collectors.toList());
		final int nextPosition = Day17.process(3, buffer, 5, 2);
		assertEquals(Stream.of(0, 5, 2, 4, 3, 1).collect(Collectors.toList()), buffer);
		assertEquals(1, nextPosition);
	}

	@Test
	void process_step9() {
		final List<Integer> buffer = Stream.of(0, 5, 7, 2, 4, 3, 8, 6, 1).collect(Collectors.toList());
		final int nextPosition = Day17.process(3, buffer, 9, 6);
		assertEquals(Stream.of(0, 9, 5, 7, 2, 4, 3, 8, 6, 1).collect(Collectors.toList()), buffer);
		assertEquals(1, nextPosition);
	}

	@Test
	void example1() {
		assertEquals(638, Day17.getValueAfter2017(3));
	}

	@Test
	void part1() {
		assertEquals(1244, Day17.getValueAfter2017(370));
	}

}