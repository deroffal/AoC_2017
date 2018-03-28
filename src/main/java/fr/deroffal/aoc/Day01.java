package fr.deroffal.aoc;

import java.util.stream.IntStream;

import fr.deroffal.aoc.util.Utils;

public class Day01 {

    public static void main(String[] args) {
        final String input = Utils.readLine("day01.txt");

        System.out.println("Partie 1 : " + calculerScore(input, 1));
        System.out.println("Partie 2 : " + calculerScore(input, input.length() / 2));
    }

    static int calculerScore(final String input, final int offset) {
        final int inputLenght = input.length();

        return IntStream.range(0, inputLenght).map(i -> {
            final char charAt = input.charAt(i);
            return charAt == input.charAt((i + offset) % inputLenght) ? Character.getNumericValue(charAt) : 0;
        }).sum();
    }
}
