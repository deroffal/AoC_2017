package fr.deroffal.aoc.kotlin

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Day05Test {

    private val day05 = Day05()

    @Test
    fun `part1 matches examples`() {
        val input = listOf(0, 3, 0, 1, -3).toIntArray()
        assertEquals(5, day05.solvePart1(input))
    }

    @Test
    fun `part2 matches examples`() {
        val input = listOf(0, 3, 0, 1, -3).toIntArray()
        assertEquals(10, day05.solvePart2(input))
    }
}