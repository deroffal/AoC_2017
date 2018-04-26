package fr.deroffal.aoc;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Day13Test {

	private List<String> input;

	private Map<Integer, Integer> firewall;

	@BeforeEach
	void setUp() {
		input = Arrays.asList("0: 3", "1: 2", "4: 4", "6: 4");
		firewall = Day13.buildFirewall(input);
	}

	@Test
	void computeRangePerLayer() {
		assertAll(
				() ->assertEquals(input.size(), firewall.size()),
				() ->assertEquals(3, firewall.get(0).intValue()),
				() ->assertEquals(2, firewall.get(1).intValue()),
				() ->assertEquals(4, firewall.get(4).intValue()),
				() ->assertEquals(4, firewall.get(6).intValue())
		);
	}

	@Test
	void exampleTotalSeverity(){
		assertEquals(24, Day13.computeTotalSeverity(firewall, 0));
	}

	@Test
	void examplePart2(){
		final List<String> input = Arrays.asList("0: 3", "1: 2", "4: 4", "6: 4");
		final Map<Integer, Integer> firewall = Day13.buildFirewall(input);
		assertEquals(10, Day13.findDelayToCrossFirewall(firewall));
	}

}