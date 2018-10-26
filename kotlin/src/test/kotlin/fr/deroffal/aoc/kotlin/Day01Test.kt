package fr.deroffal.aoc.kotlin

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.aggregator.ArgumentsAccessor
import org.junit.jupiter.params.provider.CsvSource

internal class Day01Test {

    private val day01 = Day01()

    @CsvSource(
            "3,1122",
            "4,1111",
            "0,1234",
            "9,91212129"
    )
    @ParameterizedTest(name = "Input ''{1}'' gives captcha {0}")
    fun `part1 matches examples`(arguments: ArgumentsAccessor) {
        val expected = arguments.getInteger(0)
        val input = arguments.getString(1)
        assertEquals(expected, day01.solvePart1(input))
    }

    @CsvSource(
            "6,1212",
            "0,1221",
            "4,123425",
            "12,123123",
            "4,12131415"
    )
    @ParameterizedTest(name = "Input ''{1}'' gives captcha {0}")
    fun `part2 matches examples`(expected: Int, input: String) {
        assertEquals(expected, day01.solvePart2(input))
    }
}