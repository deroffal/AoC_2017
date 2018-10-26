package fr.deroffal.aoc;

import fr.deroffal.aoc.util.Utils;

public class Day11 {

	public static void main(String[] args) {
		int x = 0, y = 0;
		int max = 0;
		for (final String direction : Utils.readLine("day11.txt").split(",")) {
			if (direction.contains("n")) {
				y += 1;
			} else {
				y -= 1;
			}

			if (direction.contains("e")) {
				x += 1;
			} else if (direction.contains("w")) {
				x -= 1;
			}

			max = Math.max(Math.max(Math.abs(x), Math.abs(y)), max);
		}

		System.out.println("Part 1 : " + Math.max(Math.abs(x), Math.abs(y)));
		System.out.println("Part 2 : " + max);
	}
}
