package fr.deroffal.aoc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import fr.deroffal.aoc.util.Utils;

class Day07Test {

	@Test
	void parentExemple_doit_etre_tknk() {
		final List<String> programms = Utils.readLines("day07.txt");
		assertEquals("tknk", Day07.findRoot(Day07.getProgrammByNames(programms), programms).getName());
	}

}