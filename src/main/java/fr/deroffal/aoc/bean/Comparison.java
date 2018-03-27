package fr.deroffal.aoc.bean;

import fr.deroffal.aoc.Day08;

/**
 * @see Day08
 */
@FunctionalInterface
public interface Comparison {

	boolean compare(final int a, final int b);
}
