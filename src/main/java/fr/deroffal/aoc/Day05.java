package fr.deroffal.aoc;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import fr.deroffal.aoc.util.Utils;

public class Day05 {

	public static void main(String[] args) {
		List<Integer> input = Utils.readLines("day05.txt").stream().mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());

		System.out.println("Partie 1 : " + countStepToEscape(input, i -> 1));
		System.out.println("Partie 2 : " + countStepToEscape(input, i -> i >= 3 ? -1 : 1));
	}

	public static int countStepToEscape(final List<Integer> input, final Function<Integer, Integer> offsetFunction) {
		final List<Integer> instructions = new ArrayList<>(input);
		int count = 0;
		int position = 0;
		while (position < instructions.size()) {
			position = getNextPosition(instructions, position, offsetFunction);
			++count;
		}
		return count;
	}

	public static int getNextPosition(final List<Integer> instructions, final int currentPosition, final Function<Integer, Integer> offsetFunction) {
		int currentPositionValue = instructions.get(currentPosition);
		instructions.set(currentPosition, currentPositionValue + offsetFunction.apply(currentPositionValue));
		return currentPosition + currentPositionValue;
	}

}
