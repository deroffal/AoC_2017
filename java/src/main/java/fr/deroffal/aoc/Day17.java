package fr.deroffal.aoc;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.deroffal.aoc.util.Utils;

public class Day17 {

	public static void main(String[] args) {
		final int numberOfSteps = Integer.parseInt(Utils.readLine("day17.txt"));
		System.out.println("Part 1 : " + getValueAfter2017(numberOfSteps));
		System.out.println("Part 2 : " + part2(numberOfSteps));
	}

	static int getValueAfter2017(final int numberOfSteps) {
		final List<Integer> buffer = Stream.of(0).collect(Collectors.toList());
		int position = 0;
		for (int i = 1; i <= 2017; i++) {
			position = process(numberOfSteps, buffer, i, position);
		}
		final int indexOf2017 = buffer.indexOf(2017);
		return buffer.get(indexOf2017 + 1);
	}

	static int process(final int numberOfSteps, final List<Integer> buffer, final int step, final int previousPosition) {
		final int position = getNextPosition(numberOfSteps, step, previousPosition);
		buffer.add(position, step);
		return position;
	}

	//Pas besoin de recréer la liste.
	private static int part2(final int numberOfSteps) {
		int position = 0;
		int lastIndexForPosistion1 = -1;
		for (int i = 1; i <= 50000000; i++) {
			final int nextPosition = getNextPosition(numberOfSteps, i, position);
			if (nextPosition == 1) {
				lastIndexForPosistion1 = i;
			}
			position = nextPosition;
		}

		return lastIndexForPosistion1;
	}

	private static int getNextPosition(final int numberOfSteps, final int step, int currentPosition) {
		return (currentPosition + numberOfSteps) % step + 1;
	}

}
