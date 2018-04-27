package fr.deroffal.aoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import fr.deroffal.aoc.util.Utils;

public class Day16 {

	private final static Map<Character, BiFunction<StringBuilder, String, StringBuilder>> danceByChar;

	static {
		danceByChar = new HashMap<>();
		danceByChar.put('s', Day16::spin);
		danceByChar.put('x', Day16::exchange);
		danceByChar.put('p', Day16::partner);
	}

	public static void main(String[] args) {
		final List<String> dances = Arrays.stream(Utils.readLine("day16.txt").split(",")).collect(Collectors.toList());

		System.out.println("Part 1 : " + dance(dances, "abcdefghijklmnop"));
		System.out.println("Partie 2 : " + getProgrammsAfterBillionDances(dances));
	}

	private static String getProgrammsAfterBillionDances(final List<String> dances) {
		String programms = "abcdefghijklmnop";
		final List<String> programmsAfterDances = new ArrayList<>();
		while (!programmsAfterDances.contains(programms)) {
			programmsAfterDances.add(programms);
			programms = dance(dances, programms);
		}
		return programmsAfterDances.get(1000000000 % programmsAfterDances.size());
	}

	static String dance(final List<String> dances, final String programmsAsString) {
		StringBuilder programms = new StringBuilder(programmsAsString);
		for (String dance : dances) {
			final Character danceChar = dance.charAt(0);
			programms = danceByChar.get(danceChar).apply(programms, dance);
		}
		return programms.toString();
	}

	static StringBuilder spin(final StringBuilder programms, final String dance) {
		final int indexToSpin = programms.length() - Integer.parseInt(dance.substring(1));
		return new StringBuilder(programms.substring(indexToSpin)).append(programms.substring(0, indexToSpin));
	}

	static StringBuilder exchange(final StringBuilder programms, final String dance) {
		final String[] positions = dance.substring(1).split("/");
		final int indexA = Integer.parseInt(positions[0]);
		final int indexB = Integer.parseInt(positions[1]);

		final char charAtA = programms.charAt(indexA);
		final char charAtB = programms.charAt(indexB);

		programms.setCharAt(indexA, charAtB);
		programms.setCharAt(indexB, charAtA);

		return programms;
	}

	static StringBuilder partner(final StringBuilder programms, final String dance) {
		final String[] partnersProgramm = dance.substring(1).split("/");

		final String a = partnersProgramm[0];
		final String b = partnersProgramm[1];

		final int indexA = programms.indexOf(a);
		final int indexB = programms.indexOf(b);

		programms.setCharAt(indexA, b.charAt(0));
		programms.setCharAt(indexB, a.charAt(0));

		return programms;
	}
}
