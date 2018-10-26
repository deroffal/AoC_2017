package fr.deroffal.aoc.bean;

import fr.deroffal.aoc.Day03;

/**
 * @see Day03
 */
public class Coordinate {

	private final int x;
	private final int y;

	public Coordinate(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final Coordinate that = (Coordinate) o;
		return x == that.x && y == that.y;
	}

	@Override
	public int hashCode() {
		return 31 * x + y;
	}

}
