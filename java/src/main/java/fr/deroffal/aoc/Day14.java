package fr.deroffal.aoc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import fr.deroffal.aoc.util.Utils;

public class Day14 {

	private static final int CHAR_1 = 49;
	private static final int GRID_MIN = 0;
	private static final int GRID_MAX = 127;

	public static void main(String[] args) {
		final String input = Utils.readLine("day14.txt");
		System.out.println("Part 1 :" + IntStream.rangeClosed(GRID_MIN, GRID_MAX).mapToLong(i -> sumForLine(input, i)).sum());
		System.out.println("Part 2 : " + countRegions(input));
	}

	private static long sumForLine(final String input, final int i) {
		final String knotHash = Day10.doKnotHash(input + "-" + i);
		return knotHash.chars().mapToLong(Day14::getSumOfUsedForCharInHash).sum();
	}

	private static long getSumOfUsedForCharInHash(final int charValue) {
		final String binaryString = charValueToBin(charValue);
		return binaryString.chars().filter(bin -> bin == CHAR_1).count();
	}

	private static String charValueToBin(final int charValue) {
		final String charAsString = String.valueOf((char) charValue);
		final int hexaToInt = Integer.parseInt(charAsString, 16);
		return Integer.toBinaryString(hexaToInt);
	}

	private static int countRegions(final String input) {
		final List<String> grid = buildGrid(input);

		int regions = 0;
		for (int j = 0; j < grid.size(); j++) {
			for (int i = 0; i < grid.get(j).toCharArray().length; i++) {
				if (grid.get(j).charAt(i) == '1') {
					++regions;
					flagNeigthboors(grid, i, j);
				}
			}
		}
		return regions;
	}

	private static void flagNeigthboors(final List<String> grid, final int i, final int j) {
		if (j >= GRID_MIN && j <= GRID_MAX && i >= GRID_MIN && i <= GRID_MAX && grid.get(j).charAt(i) == '1') {

			final StringBuilder sb = new StringBuilder(grid.get(j));
			sb.setCharAt(i, '0');
			grid.set(j, sb.toString());

			flagNeigthboors(grid, i, j - 1);
			flagNeigthboors(grid, i, j + 1);
			flagNeigthboors(grid, i - 1, j);
			flagNeigthboors(grid, i + 1, j);
		}
	}

	private static List<String> buildGrid(final String input) {
		final List<String> grid = new ArrayList<>();
		IntStream.rangeClosed(GRID_MIN, GRID_MAX).mapToObj(i -> Day10.doKnotHash(input + "-" + i)).forEach(hash -> {
			final StringBuilder sb = new StringBuilder();
			hash.chars().forEach(c -> {
				final String binaryString = Integer.toBinaryString(Integer.parseInt(String.valueOf((char) c), 16));
				sb.append(binaryString.length() == 4 ? binaryString : "0000".substring(0, 4 - binaryString.length()) + binaryString);
			});
			grid.add(sb.toString());
		});
		return grid;
	}

}
