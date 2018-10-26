package fr.deroffal.aoc.kotlin

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day04Test {

    private val day04 = Day04()

    @Test
    fun `part1 matches examples`() {
        val input: List<String> = listOf("aa bb cc dd ee", "aa bb cc dd aa", "aa bb cc dd aaa")
        assertEquals(2, day04.solvePart1(input))
    }

    @Test
    fun `part2 matches examples`() {
        val input: List<String> = listOf("abcde fghij", "abcde xyz ecdab", "a ab abc abd abf abj", "iiii oiii ooii oooi oooo", "oiii ioii iioi iiio")
        assertEquals(3, day04.solvePart2(input))
    }
}