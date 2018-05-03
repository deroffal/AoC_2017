package fr.deroffal.aoc.bean;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum ComparisonEnum {

	DIFFERENT("!=", (a, b) -> !a.equals(b)),

	EQUAL("==", Integer::equals),

	GREATER_OR_EQUAL(">=", (a, b) -> a >= b),

	LOWER_OR_EQUAL("<=", (a, b) -> a <= b),

	GREATER(">", (a, b) -> a > b),

	LOWER("<", (a, b) -> a < b);

	private final String comparator;

	private final BiPredicate<Integer, Integer> predicate;

	ComparisonEnum(final String comparator, final BiPredicate<Integer, Integer> predicate) {
		this.comparator = comparator;
		this.predicate = predicate;
	}

	public String getComparator() {
		return comparator;
	}

	private boolean compare(final int a, final int b) {
		return predicate.test(a, b);
	}

	public static boolean findAndCompare(final String comparator, final int a, final int b) {
		return Arrays.stream(values()).filter(comparisonEnum -> comparisonEnum.getComparator().equals(comparator)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Comparateur '" + comparator + "' inconnu!")).compare(a, b);
	}
}
