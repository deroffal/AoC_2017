package fr.deroffal.aoc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.deroffal.aoc.bean.Generator;

class Day15Test {

	@Test
	void getNextValue_part1() {
		assertEquals(1092455L, Day15.getNextValuePart1(65, Generator.A));
		assertEquals(430625591L, Day15.getNextValuePart1(8921, Generator.B));

		assertEquals(1352636452L, Day15.getNextValuePart1(1744312007, Generator.A));
		assertEquals(285222916L, Day15.getNextValuePart1(137874439, Generator.B));
	}


	@Test
	void getLast16Digits_whenMoreThan16digits(){
		assertEquals("1010101101100111", Day15.getLast16Digits(1092455));
		assertEquals("1111011100111001", Day15.getLast16Digits(1181022009));
		assertEquals("1110001101001010", Day15.getLast16Digits(245556042));
		assertEquals("0001011011000111", Day15.getLast16Digits(1744312007));
		assertEquals("1001100000100100", Day15.getLast16Digits(1352636452));
	}

	@Test
	void getLast16Digits_whenLessThan16digits(){
		assertEquals("0000000000000000", Day15.getLast16Digits(0));
		assertEquals("0000000000000001", Day15.getLast16Digits(1));
	}

	@Test
	void getNextValue_part2() {
		assertEquals(1992081072L, Day15.getNextValuePart2(1352636452L, Generator.A));
		assertEquals(862516352L, Day15.getNextValuePart2(1233683848, Generator.B));

		assertEquals(530830436L, Day15.getNextValuePart2(1992081072, Generator.A));
		assertEquals(1159784568L, Day15.getNextValuePart2(862516352, Generator.B));
	}
}