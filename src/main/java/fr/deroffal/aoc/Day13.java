package fr.deroffal.aoc;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import fr.deroffal.aoc.util.Utils;

public class Day13 {

	public static void main(String[] args) {
		final List<String> input = Utils.readLines("day13.txt");
		final Map<Integer, Integer> firewall = buildFirewall(input);

		System.out.println("Part 1 : " + computeTotalSeverity(firewall, 0));
		System.out.println("Part 2 : " + findDelayToCrossFirewall(firewall));
	}

	static Map<Integer, Integer> buildFirewall(final List<String> input) {
		return input.stream().map(line -> line.split(": ")).collect(Collectors.toMap(tab -> Integer.parseInt(tab[0]), tab -> Integer.parseInt(tab[1])));
	}

	static int computeTotalSeverity(final Map<Integer, Integer> firewall, final int delay) {
		final Predicate<Map.Entry<Integer, Integer>> isCaught = e -> (e.getKey() + delay) % (2 * (e.getValue() - 1)) == 0;
		final ToIntFunction<Map.Entry<Integer, Integer>> computeSeverity = e -> (delay + e.getKey()) * e.getValue();
		return firewall.entrySet().stream().filter(isCaught).mapToInt(computeSeverity).sum();
	}

	static int findDelayToCrossFirewall(final Map<Integer, Integer> rangePerLayer) {
		int delay = 0;
		do {
			delay++;
		} while (computeTotalSeverity(rangePerLayer, delay) != 0);
		return delay;
	}

}
