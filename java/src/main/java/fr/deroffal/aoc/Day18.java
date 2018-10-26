package fr.deroffal.aoc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.deroffal.aoc.util.Utils;

public class Day18 {

	private static final Map<Character, Long> valueByRegister = new HashMap<>();

	private static long sound = -1;

	public static void main(String[] args) {
		final List<String> instructions = Utils.readLines("day18.txt");

		System.out.println("Part 1 : " + part1(instructions));
	}

	static long part1(final List<String> instructions) {
		for (int i = 0; i < instructions.size(); i++) {
			final String line = instructions.get(i);
			final String[] tokens = line.split(" ");
			final String instruction = tokens[0];
			final char register = tokens[1].charAt(0);

			final long x = valueByRegister.computeIfAbsent(register, key -> 0L);
			final long y = tokens.length == 3 ? getValueAsLong(tokens[2]) : -1;

			switch (instruction) {
			case "set":
				valueByRegister.put(register, y);
				break;
			case "add":
//				valueByRegister.put(register, x + y);
				valueByRegister.merge(register, y, (oldValue, newValue) -> oldValue == null ? newValue : oldValue+newValue);
				break;
			case "mul":
				valueByRegister.put(register, x * y);
				break;
			case "mod":
				valueByRegister.put(register, x % y);
				break;
			case "jgz":
				if (x > 0) {
					i += y - 1;
				}
				break;
			case "rcv":
				if (x != 0) {
					return sound;
				}
				break;
			case "snd":
				sound = x;
				break;
			default:
				throw new IllegalArgumentException("Instruction non-reconnue! : " + instruction);
			}
		}
		throw new IllegalArgumentException("Oups!");
	}

	private static Long getValueAsLong(final String o) {
		try {
			return Long.parseLong(o);
		} catch (final NumberFormatException e) {
			return valueByRegister.computeIfAbsent(o.charAt(0), key -> 0L);
		}
	}
}
