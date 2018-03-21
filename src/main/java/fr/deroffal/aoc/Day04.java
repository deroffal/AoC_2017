package fr.deroffal.aoc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import fr.deroffal.aoc.util.Utils;

public class Day04 {

	public static void main(String[] args) {
		final List<String> input = Utils.readLines("day04.txt");

		System.out.println("Partie 1 : " + countValidPassword(input));
		System.out.println("Partie 2 : " + countValidPasswordWithAnagram(input));

	}

	private static long countValidPassword(final List<String> input) {
		return input.stream().filter(Day04::isLineValid).count();
	}

	public static boolean isLineValid(final String ligne) {
		final String[] ligneDecoupee = ligne.split(" ");
		return ligneDecoupee.length == Arrays.stream(ligneDecoupee).collect(Collectors.toSet()).size();
	}

	private static long countValidPasswordWithAnagram(final List<String> input) {
		return input.stream().filter(Day04::isLineValidWithAnagram).count();
	}

	public static boolean isLineValidWithAnagram(final String ligne) {
		final String[] ligneDecoupee = ligne.split(" ");
		return ligneDecoupee.length == Arrays.stream(ligneDecoupee).map(Day04::sortString).collect(Collectors.toSet()).size();
	}

	private static String sortString(final String s) {
		return Arrays.stream(s.split("")).sorted().collect(Collectors.joining());
	}
}