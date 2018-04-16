package fr.deroffal.aoc;

import java.util.Collections;
import java.util.List;

import fr.deroffal.aoc.util.Utils;

public class Day02 {

	public static void main(String[] args) {
		List<String> input = Utils.readLines("day02.txt");

		System.out.println("Partie 1 : " + calculerDifferenceExtremum(input));
		System.out.println("Partie 2 : " + calculerResteDivision(input));

	}

	private static int calculerDifferenceExtremum(final List<String> input) {
		return input.stream().mapToInt(Day02::calculerDifference).sum();
	}

	static int calculerDifference(final String s) {
		final List<Integer> liste = Utils.splitToIntegerList("\t", s);
		return Collections.max(liste) - Collections.min(liste);
	}

	private static int calculerResteDivision(final List<String> input) {
		return input.stream().mapToInt(Day02::calculerDifferenceDivision).sum();
	}

	static int calculerDifferenceDivision(final String s) {
		final List<Integer> liste = Utils.splitToIntegerList("\t", s);
		liste.sort(Collections.reverseOrder());

		int listeSize = liste.size();
		for (int x = 0; x < listeSize; x++) {
			int xValue = liste.get(x);
			for (int y = x + 1; y < listeSize; y++) {
				int yValue = liste.get(y);
				if (xValue % yValue == 0) {
					return xValue / yValue;
				}
			}
		}
		throw new IllegalArgumentException("Un résultat aurait dû être trouvé!");
	}

}
