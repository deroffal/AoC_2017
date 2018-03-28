package fr.deroffal.aoc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Day04Test {

	@Test
	void aa_bb_cc_dd_ee_valide() {
		assertTrue(Day04.isLineValid("aa bb cc dd ee"));
	}

	@Test
	void aa_bb_cc_dd_aa_non_valide() {
		assertFalse(Day04.isLineValid("aa bb cc dd aa"));
	}

	@Test
	void aa_bb_cc_dd_aaa_valide() {
		assertTrue(Day04.isLineValid("aa bb cc dd aaa"));
	}

	@Test
	void abcde_fghij_valide_anagram() {
		assertTrue(Day04.isLineValidWithAnagram("abcde fghij"));
	}

	@Test
	void abcde_xyz_ecdab_non_valide_anagram() {
		assertFalse(Day04.isLineValidWithAnagram("abcde xyz ecdab"));
	}

	@Test
	void a_ab_abc_abd_abf_abj_valide_anagram() {
		assertTrue(Day04.isLineValidWithAnagram("a ab abc abd abf abj"));
	}

	@Test
	void iiii_oiii_ooii_oooi_oooo_valide_anagram() {
		assertTrue(Day04.isLineValidWithAnagram("iiii oiii ooii oooi oooo"));
	}

	@Test
	void oiii_ioii_iioi_iiio_non_valide_anagram() {
		assertFalse(Day04.isLineValidWithAnagram("oiii ioii iioi iiio"));
	}
}
