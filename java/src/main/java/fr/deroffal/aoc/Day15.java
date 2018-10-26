package fr.deroffal.aoc;

import java.util.List;

import fr.deroffal.aoc.bean.Generator;
import fr.deroffal.aoc.util.Utils;

public class Day15 {

	private final static int DIVISOR = 2147483647;

	private final static String ZERO = "0000000000000000";

	public static void main(String[] args) {
		final List<String> input = Utils.readLines("day15.txt");
		long aValue = Integer.parseInt(input.get(0).substring(24));
		long bValue = Integer.parseInt(input.get(1).substring(24));

		System.out.println("Part 1 :" + getMatchCountPart1(aValue, bValue));
		System.out.println("Part 2 :" + getMatchCountPart2(aValue, bValue));
	}

	private static int getMatchCountPart1(long aValue, long bValue) {
		int matchCount = 0;
		for (int i = 0; i < 40000000; i++) {
			aValue = getNextValuePart1(aValue, Generator.A);
			bValue = getNextValuePart1(bValue, Generator.B);

			if (getLast16Digits(aValue).equals(getLast16Digits(bValue))) {
				matchCount++;
			}
		}
		return matchCount;
	}

	static long getNextValuePart1(final long previousValue, final Generator generator) {
		return previousValue * generator.getFactor() % DIVISOR;
	}

	private static int getMatchCountPart2(long aValue, long bValue) {
		int matchCount = 0;
		for (int i = 0; i < 5000000; i++) {
			aValue = getNextValuePart2(aValue, Generator.A);
			bValue = getNextValuePart2(bValue, Generator.B);

			if (getLast16Digits(aValue).equals(getLast16Digits(bValue))) {
				matchCount++;
			}
		}
		return matchCount;
	}

	static long getNextValuePart2(final long previousValue, final Generator generator) {
		long candidate = previousValue;
		do {
			candidate = getNextValuePart1(candidate, generator);
		} while (candidate % generator.getCriteria() != 0);

		return candidate;
	}

	static String getLast16Digits(final long value) {
		final String binaryString = Long.toBinaryString(value);
		final int length = binaryString.length();
		return length > 15 ? binaryString.substring(length - 16, length) : ZERO.substring(0, 16 - length) + binaryString;
	}
}
