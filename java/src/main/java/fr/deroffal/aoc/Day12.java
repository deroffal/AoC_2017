package fr.deroffal.aoc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.deroffal.aoc.util.Utils;

public class Day12 {

	private static final String RELATION = "<-> ";
	private static final int RELATION_LENGTH = RELATION.length();

	private static final Map<Integer, List<Integer>> PROGRAMMS_RELATED_TO_PARENT = new HashMap<>();

	public static void main(String[] args) {
		Utils.readLines("day12.txt").forEach(line -> {
			final int key = Integer.parseInt(line.split(" ")[0]);
			final List<Integer> value = Arrays.stream(line.substring(line.indexOf(RELATION) + RELATION_LENGTH).split(", ")).map(Integer::valueOf).collect(Collectors.toList());
			PROGRAMMS_RELATED_TO_PARENT.put(key, value);
		});

		final Set<Integer> programmesRegroupes = recupererProgrammesPour(0);
		System.out.println("Part 1 : " + programmesRegroupes.size());

		int partie2 = 1;
		for (final Integer key : PROGRAMMS_RELATED_TO_PARENT.keySet()) {
			if (!programmesRegroupes.contains(key)) {
				programmesRegroupes.addAll(recupererProgrammesPour(key));
				++partie2;
			}
		}
		System.out.println("Partie 2 : " + partie2);

	}

	private static Set<Integer> recupererProgrammesPour(final int parent) {
		return regrouperAvec(parent, Stream.of(parent).collect(Collectors.toSet()));
	}

	private static Set<Integer> regrouperAvec(final Integer parent, final Set<Integer> enfantsDejaPresents) {
		for (final Integer enfant : PROGRAMMS_RELATED_TO_PARENT.get(parent)) {
			if (!enfantsDejaPresents.contains(enfant)) {
				enfantsDejaPresents.add(enfant);
				regrouperAvec(enfant, enfantsDejaPresents);
			}
		}
		return enfantsDejaPresents;
	}

}
