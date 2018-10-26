package fr.deroffal.aoc.kotlin

import fr.deroffal.aoc.kotlin.tools.getNumericValue

/**
 * @see <a href="https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.text/zip.html">Zip</a>
 */
fun main(args: Array<String>) {
    val input = fr.deroffal.aoc.kotlin.tools.readLine("day01.txt")
    val day01 = Day01()
    println("Part 1 : ${day01.solvePart1(input)}")
    println("Part 2 : ${day01.solvePart2(input)}")
}

class Day01 {

    internal fun solvePart1(input: String): Int = (input + input[0]).zipWithNext().filter { it.first == it.second }.map { it.first.getNumericValue() }.sum()

    internal fun solvePart2(input: String): Int {
        val half = input.length / 2
        return (input.substring(0, half) zip input.substring(half)).filter { it.first == it.second }.map { 2 * it.first.getNumericValue() }.sum()
    }

}
