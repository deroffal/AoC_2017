package fr.deroffal.aoc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import fr.deroffal.aoc.bean.Comparison;
import fr.deroffal.aoc.bean.Operation;
import fr.deroffal.aoc.util.Utils;

public class Day08 {

	private static final Function<String, Integer> ZERO_IF_ABSENT = name -> 0;

	private static final Map<String, Operation> operations;
	private static final Map<String, Comparison> comparisons;
	private static final Map<String, Integer> valueByName = new HashMap<>();

	static {
		operations = new HashMap<>();
		operations.put("inc", (a, b) -> a + b);
		operations.put("dec", (a, b) -> a - b);

		comparisons = new HashMap<>();
		comparisons.put("!=", (a, b) -> a != b);
		comparisons.put("==", (a, b) -> a == b);
		comparisons.put(">=", (a, b) -> a >= b);
		comparisons.put("<=", (a, b) -> a <= b);
		comparisons.put(">", (a, b) -> a > b);
		comparisons.put("<", (a, b) -> a < b);
	}

	public static void main(String[] args) {
		Utils.readLines("day08.txt").forEach(line -> {
			String[] tokens = line.split(" ");
			//tokens[3] == "if" !
			doLine(tokens[0], tokens[1], tokens[2], tokens[4], tokens[5], tokens[6]);
		});

		System.out.println("Partie 1 : " + Collections.max(valueByName.values()));
	}

	private static void doLine(final String name1, final String operationOperator, final String value1, final String name2, final String comparisonOperator, final String value2) {
		if (comparisons.get(comparisonOperator).compare(valueByName.computeIfAbsent(name2, ZERO_IF_ABSENT), Integer.parseInt(value2))) {
			valueByName.put(name1, operations.get(operationOperator).apply(valueByName.computeIfAbsent(name1, ZERO_IF_ABSENT), Integer.parseInt(value1)));
		}
	}

}
