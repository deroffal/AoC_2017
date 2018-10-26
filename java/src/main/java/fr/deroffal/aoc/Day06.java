package fr.deroffal.aoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fr.deroffal.aoc.util.Utils;

public class Day06 {

	public static void main(String[] args) {
		final List<Integer> blocks = Utils.readLineToIntegerList("day06.tx", "\t");

		final Map<List<Integer>, Integer> previousRedistributions = new HashMap<>();
		final Set<List<Integer>> redistributions = previousRedistributions.keySet();

		int cycles = 0;
		List<Integer> blocksAfterRedistribution = new ArrayList<>(blocks);
		while (!redistributions.contains(blocksAfterRedistribution)) {
			previousRedistributions.put(blocksAfterRedistribution, cycles);
			blocksAfterRedistribution = redistribute(blocksAfterRedistribution);
			++cycles;
		}

		System.out.println("Partie 1 : " + cycles);
		System.out.println("Partie 2 : " + (cycles - previousRedistributions.get(blocksAfterRedistribution)));
	}

	static List<Integer> redistribute(final List<Integer> blocks) {
		final int blockSize = blocks.size();

		int maxBlock = Collections.max(blocks);
		int maxBlockPosition = blocks.indexOf(maxBlock);

		blocks.set(maxBlockPosition, 0);

		while (maxBlock > 0) {
			final int index = (maxBlockPosition + 1) % blockSize;
			blocks.set(index, blocks.get(index) + 1);
			--maxBlock;
			++maxBlockPosition;
		}

		return blocks;
	}
}
