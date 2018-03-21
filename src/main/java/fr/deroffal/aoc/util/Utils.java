package fr.deroffal.aoc.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

	private Utils() {
	}

	public static List<String> readLines(final String nomFichier) {
		try {
			return Files.readAllLines(Paths.get(Utils.class.getClassLoader().getResource(nomFichier).toURI()));
		} catch (URISyntaxException | IOException e) {
			throw new IllegalArgumentException("Le fichier n'a pas pu être lu!");
		}
	}

	public static String readLine(final String nomFichier) {
		return readLines(nomFichier).get(0);
	}

	public static List<Integer> readLineToIntegerList(final String nomFichier, final String splitRegex) {
		return splitToIntegerList(splitRegex, readLine(nomFichier));
	}

	public static List<Integer> splitToIntegerList(final String splitRegex, final String string) {
		return Arrays.stream(string.split(splitRegex)).mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());
	}

}
