package fr.deroffal.aoc;

import fr.deroffal.aoc.util.Utils;

public class Day09 {

	private static int garbageSize = 0;

	public static void main(String[] args) {
		final String input = Utils.readLine("day09.txt");

		System.out.println("Partie 1 : " + countScore(input));
		System.out.println("Partie 2 : " + garbageSize);

	}

	static int countScore(final String in) {
		final String withoutGarbage = removeGarbage(in);
		int score = 0;

		int localScore = 0;
		for (final char c : withoutGarbage.toCharArray()) {
			if (c == '{') {
				localScore++;
			} else if (c == '}') {
				score += localScore--;
			}
		}
		return score;
	}

	static String removeGarbage(final String input) {
		final String whitoutCanceled = removeCanceledCharacters(input);
		final StringBuilder out = new StringBuilder();
		for (int i = 0; i < whitoutCanceled.length(); i++) {
			final char charAt = whitoutCanceled.charAt(i);
			if (charAt == '<') {
				final int garbageEnd = whitoutCanceled.indexOf('>', i);
				garbageSize += (garbageEnd - i - 1);
				i = garbageEnd;
			} else {
				out.append(charAt);
			}
		}
		return out.toString();
	}

	static String removeCanceledCharacters(final String in) {
		final StringBuilder out = new StringBuilder();
		for (int i = 0; i < in.length(); i++) {
			final char charAt = in.charAt(i);
			if (charAt == '!') {
				++i;
			} else {
				out.append(charAt);
			}
		}
		return out.toString();
	}

}
