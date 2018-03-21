package fr.deroffal.aoc;

import java.util.HashMap;
import java.util.Map;

import fr.deroffal.aoc.bean.Coordinate;

public class Day03 {

	private static final int INPUT = 361527;

	/**
	 * Construire la spirale :
	 * <p>
	 * 0 : x = 0; y = 0
	 * <p>
	 * 1 : x+1
	 * 2 : y+1
	 * <p>
	 * 3 : x-1  4 : x-1
	 * 5 : y-1  6 : y-1
	 * <p>
	 * 7 : x+1  8 : x+1  9 : x+1
	 * 10 : y-1  11 : y-1 12 : y-1
	 * <p>
	 * ...
	 */
	public static void main(String[] args) {

		System.out.println("Partie 1 " + part1(INPUT));
		System.out.println("Partie 2 " + part2(INPUT));
	}

	/**
	 * @return |x|+|y|-1
	 */
	public static int part1(final int input) {
		Coordinate coordinate = new Coordinate(0, 0);

		int posX = 0, posY = 0;

		int count = 0;

		for (int step = 0; count <= input; step++) {
			double incOrDec = Math.pow(-1, step);
			for (int x = 0; x < step && count <= input; x++, count++, posX += incOrDec) {
				coordinate = new Coordinate(posX, posY);
			}
			for (int y = 0; y < step && count <= input; y++, count++, posY += incOrDec) {
				coordinate = new Coordinate(posX, posY);
			}
		}

		return Math.abs(coordinate.getX()) + Math.abs(coordinate.getY()) - 1;
	}

	public static int part2(final int input) {
		final Map<Coordinate, Integer> coordinateByValue = new HashMap<>();
		Coordinate coordinate = new Coordinate(0, 0);
		coordinateByValue.put(coordinate, 1);

		int posX = 0, posY = 0;

		int count = 1;
		for (int step = 0; count <= input; step++) {
			double incOrDec = Math.pow(-1, step + 1);
			for (int x = 0; x < step && count <= input; x++) {
				posX += incOrDec;
				count = computeValueFromNeighbors(coordinateByValue, posX, posY);
				coordinate = new Coordinate(posX, posY);
				coordinateByValue.put(coordinate, count);
			}
			for (int y = 0; y < step && count <= input; y++) {
				posY += incOrDec;
				count = computeValueFromNeighbors(coordinateByValue, posX, posY);
				coordinate = new Coordinate(posX, posY);
				coordinateByValue.put(coordinate, count);
			}
		}
		return coordinateByValue.get(coordinate);
	}

	private static int computeValueFromNeighbors(final Map<Coordinate, Integer> coordinateByValue, final int posX, final int posY) {
		int value = 0;
		for (int x = posX - 1; x <= posX + 1; x++) {
			for (int y = posY - 1; y <= posY + 1; y++) {
				final Integer neighborValue = coordinateByValue.get(new Coordinate(x, y));
				value += neighborValue != null ? neighborValue : 0;
			}
		}
		return value;
	}

}
