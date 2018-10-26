package fr.deroffal.aoc.kotlin

import fr.deroffal.aoc.kotlin.tools.readLines

fun main(args: Array<String>) {
    val input = readLines("day05.txt").map { it.toInt() }.toIntArray()
    val day05 = Day05()
    println("Part 1 : ${day05.solvePart1(input.clone())}")
    println("Part 2 : ${day05.solvePart2(input.clone())}")
}

class Day05 {

    fun solvePart1(input: IntArray): Int = jump(input)

    fun solvePart2(input: IntArray): Int = jump(input) { if (it >= 3) -1 else 1 }

    private fun jump(input: IntArray, offsetFunction: (Int) -> Int = { 1 }): Int {
        var count = 0
        var position = 0
        while (position < input.size) {
            position = getNextPosition(input, position, offsetFunction)
            ++count
        }
        return count
    }

    private fun getNextPosition(instructions: IntArray, position: Int, offsetFunction: (Int) -> Int): Int {
        val currentPositionValue = instructions[position]
        instructions[position] = currentPositionValue + offsetFunction(currentPositionValue)
        return position + currentPositionValue
    }

}