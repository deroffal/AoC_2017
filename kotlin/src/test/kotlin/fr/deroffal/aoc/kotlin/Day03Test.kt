package fr.deroffal.aoc.kotlin

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class Day03Test {

    private val day03 = Day03()

    @CsvSource(
            "0,1",
            "3,12",
            "2,23",
            "31,1024"
    )
    @ParameterizedTest(name = "Manhattan distance to  {1} is {0}")
    fun `part1 matches examples`(expected: Int, input: Int) {
        assertEquals(expected, day03.solvePart1(input))
    }

    @CsvSource(
            "2,1",
            "4,2",
            "4,3",
            "5,4",
            "10,5"
    )
    @ParameterizedTest(name = "First value larger than {1} is {0}")
    fun `part2 matches the five 1st values`(expected: Int, input: Int) {
        assertEquals(expected, day03.solvePart2(input))
    }
}