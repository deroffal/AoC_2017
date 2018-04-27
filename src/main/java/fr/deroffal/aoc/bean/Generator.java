package fr.deroffal.aoc.bean;

import fr.deroffal.aoc.Day15;

/**
 * @see Day15
 */
public enum Generator {
	A(16807, 4), B(48271, 8);

	private final int factor;

	private final int criteria;

	Generator(final int factor, final int criteria) {
		this.factor = factor;
		this.criteria = criteria;
	}

	public int getFactor() {
		return factor;
	}

	public int getCriteria() {
		return criteria;
	}
}
