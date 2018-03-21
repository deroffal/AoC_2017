package fr.deroffal.aoc.bean;

import java.util.ArrayList;
import java.util.List;

import fr.deroffal.aoc.Day07;

/**
 * @see Day07
 */
public class Programm {

	private final String name;

	private final int weight;

	private final List<Programm> children = new ArrayList<>();

	private Programm parent;

	public Programm(final String name, final int weight) {
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	public List<Programm> getChildren() {
		return children;
	}

	public Programm getParent() {
		return parent;
	}

	public void setParent(final Programm parent) {
		this.parent = parent;
	}

	public int computeTotalWeight() {
		return weight + children.stream().mapToInt(Programm::computeTotalWeight).sum();
	}

	public void addChild(final Programm child) {
		children.add(child);
		child.setParent(this);
	}

}
