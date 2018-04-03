package fr.deroffal.aoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import fr.deroffal.aoc.util.Utils;

public class Day10 {

	private static final List<Integer> SEQUENCE_END = Arrays.asList(17, 31, 73, 47, 23);

	private static int position;
	private static int skipSize;

	public static void main(String[] args) {
		final List<Integer> lengthSequence = Utils.readLineToIntegerList("day10.txt", ",");

		int part1 = part1(IntStream.rangeClosed(0, 255).boxed().collect(Collectors.toList()), lengthSequence);
		System.out.println("Partie 1 : " + part1);

		final String input = Utils.readLine("day10.txt");
		System.out.println("Partie 2 : " + doKnotHash(input, IntStream.rangeClosed(0, 255).boxed().collect(Collectors.toList())));
	}

	static int part1(final List<Integer> numbers, final List<Integer> lengthSequence) {
		position = 0;
		skipSize = 0;
		doSingleRound(numbers, lengthSequence);
		return numbers.get(0) * numbers.get(1);
	}

	private static void doSingleRound(final List<Integer> numbers, final List<Integer> lengthSequence) {
		for (final Integer length : lengthSequence) {
			position = reverse(numbers, position, length, skipSize);
			skipSize++;
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

	static String doKnotHash(final String input, final List<Integer> numbers) {
		//initialisation
		position = 0;
		skipSize = 0;
		final List<Integer> lengthSequence = getLength(input);

		//sparse hash
		doSparseHash(numbers, lengthSequence, 64);

		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 16; i++) {
			final int start = i * 16;
			int xor = numbers.get(start);
			for (int j = 1; j < 16; j++) {
				final Integer integer = numbers.get(start + j);
				xor = xor ^ integer;
			}
			String hexa = Integer.toHexString(xor);

			String padded = "00".substring(hexa.length()) + hexa;
			sb.append(padded);
		}


		//dense hash
		return sb.toString();
	}

	static List<Integer> getLength(final String input) {
		//toAscii
		final List<Integer> lengthSequence = input.chars().boxed().collect(Collectors.toList());
		//ajouter le suffixe
		lengthSequence.addAll(SEQUENCE_END);
		return lengthSequence;
	}

	static void doSparseHash(final List<Integer> numbers, final List<Integer> lengthSequence, final int numberOfRounds) {
		IntStream.range(0, numberOfRounds).forEach(round -> doSingleRound(numbers, lengthSequence));
	}

}
