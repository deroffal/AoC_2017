package fr.deroffal.aoc.kotlin

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day02Test {

    private val day02 = Day02()

    @Test
    fun `part1 matches examples`() {
        val input: List<String> = listOf("5 1 9 5", "7 5 3", "2 4 6 8")
        assertEquals(18, day02.solvePart1(input))
    }

    @Test
    fun `part2 matches examples`() {
        val input: List<String> = listOf("5 9 2 8", "9 4 7 3", "3 8 6 5")
        assertEquals(9, day02.solvePart2(input))
    }

}
