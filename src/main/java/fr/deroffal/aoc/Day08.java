package fr.deroffal.aoc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import fr.deroffal.aoc.bean.ComparisonEnum;
import fr.deroffal.aoc.bean.OperationEnum;
import fr.deroffal.aoc.util.Utils;

public class Day08 {

	private static final Function<String, Integer> ZERO_IF_ABSENT = name -> 0;

	private static final Map<String, Integer> valueByName = new HashMap<>();

	private static int maximum = 0;

	public static void main(String[] args) {
		Utils.readLines("day08.txt").forEach(line -> {
			String[] tokens = line.split(" ");
			//tokens[3] == "if" !
			int newValue = doLine(tokens[0], tokens[1], tokens[2], tokens[4], tokens[5], tokens[6]);

			if (newValue > maximum) {
				maximum = newValue;
			}
		});

		System.out.println("Partie 1 : " + Collections.max(valueByName.values()));
		System.out.println("Partie 2 : " + maximum);
	}

	private static int doLine(final String name1, final String operationOperator, final String value1, final String name2, final String comparisonOperator, final String value2) {
		int newValue = 0;
		if (ComparisonEnum.findAndCompare(comparisonOperator, valueByName.computeIfAbsent(name2, ZERO_IF_ABSENT), Integer.parseInt(value2))) {
			valueByName.put(name1, newValue = OperationEnum.findAndApply(operationOperator, valueByName.computeIfAbsent(name1, ZERO_IF_ABSENT), Integer.parseInt(value1)));
			return newValue;
		}
		return newValue;
	}

}
