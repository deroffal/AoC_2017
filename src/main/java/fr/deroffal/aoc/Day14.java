package fr.deroffal.aoc;

import java.util.stream.IntStream;

import fr.deroffal.aoc.util.Utils;

public class Day14 {

	public static void main(String[] args) {
		final String input = Utils.readLine("day14.txt");
		System.out.println("Part 1 :" + IntStream.range(0, 128).mapToLong(i -> sumForLine(input, i)).sum());
	}

	private static long sumForLine(final String input, final int i) {
		final String knotHash = Day10.doKnotHash(input + "-" + i);
		return knotHash.chars().mapToLong(Day14::getSumOfUsedForCharInHash).sum();
	}

	private static long getSumOfUsedForCharInHash(final int charValue) {
		final String binaryString = charValueToBin(charValue);
		return binaryString.chars().filter(bin -> bin == 49).count();
	}

	private static String charValueToBin(final int charValue) {
		final String charAsString = String.valueOf((char) charValue);
		final int hexaToInt = Integer.parseInt(charAsString, 16);
		return Integer.toBinaryString(hexaToInt);
	}

}
