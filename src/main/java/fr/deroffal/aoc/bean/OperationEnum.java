package fr.deroffal.aoc.bean;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum OperationEnum {

	INC("inc", (a, b) -> a + b),

	DEC("dec", (a, b) -> a - b);

	private final String libelle;

	private final BinaryOperator<Integer> operator;

	OperationEnum(final String libelle, final BinaryOperator<Integer> operator) {
		this.libelle = libelle;
		this.operator = operator;
	}

	public String getLibelle() {
		return libelle;
	}

	private int apply(final int a, final int b) {
		return operator.apply(a, b);
	}

	public static int findAndApply(final String operator, final int a, final int b) {
		return Arrays.stream(values()).filter(operationEnum -> operationEnum.getLibelle().equals(operator)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("Opérateur '" + operator + "' inconnu!")).apply(a, b);
	}

}
