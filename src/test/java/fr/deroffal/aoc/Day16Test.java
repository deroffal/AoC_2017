package fr.deroffal.aoc;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class Day16Test {


	@Test
	void spin() {
		final StringBuilder programms = new StringBuilder("abcde");
		assertEquals("cdeab", Day16.spin(programms, "s3").toString());
		assertEquals("eabcd", Day16.spin(programms, "s1").toString());
	}

	@Test
	void exchange() {
		final StringBuilder programms = new StringBuilder("eabcd");
		assertEquals("eabdc", Day16.exchange(programms, "x3/4").toString());
	}

	@Test
	void partner() {
		final StringBuilder programms = new StringBuilder("eabdc");
		assertEquals("baedc", Day16.partner(programms, "pe/b").toString());
	}

	@Test
	void examplePart1(){
		final List<String> example = Arrays.asList("s1", "x3/4", "pe/b");
		assertEquals("baedc", Day16.dance(example, "abcde"));
	}

	@Test
	void examplePart2(){
		final List<String> example = Arrays.asList("s1", "x3/4", "pe/b");
		final String abcde = Day16.dance(example, "abcde");
		assertEquals("ceadb", Day16.dance(example, abcde));
	}
}