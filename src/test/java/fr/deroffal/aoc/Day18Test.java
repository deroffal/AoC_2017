package fr.deroffal.aoc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class Day18Test {

	@Test
	void example1() {
		final List<String> instructions = Arrays.asList("set a 1", "add a 2", "mul a a", "mod a 5", "snd a", "set a 0", "rcv a", "jgz a -1", "set a 1", "jgz a -2");
		assertEquals(4, Day18.part1(instructions));
	}
}