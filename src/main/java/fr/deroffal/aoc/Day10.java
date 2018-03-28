package fr.deroffal.aoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import fr.deroffal.aoc.util.Utils;

public class Day10 {

	public static void main(String[] args) {
		final List<Integer> lengths = Utils.readLineToIntegerList("day10.txt", ",");
		final List<Integer> numbers = IntStream.rangeClosed(0, 255).boxed().collect(Collectors.toList());

		int part1 = getPart1(numbers, lengths);
		System.out.println("Partie 1 : " + part1);
	}

	static int getPart1(final List<Integer> numbers, final List<Integer> lengths) {
		doOneStep(numbers, lengths);
		return numbers.get(0) * numbers.get(1);
	}

	private static void doOneStep(final List<Integer> numbers, final List<Integer> lengths) {
		int position = 0;
		for (int skipSize = 0; skipSize < lengths.size(); skipSize++) {
			position = reverse(numbers, position, lengths.get(skipSize), skipSize);
		}
	}

	static int reverse(final List<Integer> numbers, final int position, final int length, final int skipSize) {
		final int inputSize = numbers.size();

		final List<Integer> sublist = new ArrayList<>(length);
		IntStream.range(position, position + length).forEach(i -> sublist.add(numbers.get(i % inputSize)));
		Collections.reverse(sublist);

		IntStream.range(0, sublist.size()).forEach(i -> numbers.set((position + i) % inputSize, sublist.get(i)));

		return (position + length + skipSize) % inputSize;
	}

}
