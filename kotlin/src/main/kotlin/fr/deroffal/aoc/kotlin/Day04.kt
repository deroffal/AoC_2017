package fr.deroffal.aoc.kotlin

import fr.deroffal.aoc.kotlin.tools.readLines
import fr.deroffal.aoc.kotlin.tools.sort

fun main(args: Array<String>) {
    val input = readLines("day04.txt")
    val day04 = Day04()
    println("Part 1 : ${day04.solvePart1(input)}")
    println("Part 2 : ${day04.solvePart2(input)}")
}

class Day04 {

    fun solvePart1(input: List<String>): Int = input.map { it.split(" ") }.filter { it.size == it.toSet().size }.count()

    fun solvePart2(input: List<String>): Int = input.map { it.split(" ").map { it.sort() } }.filter { it.size == it.toSet().size }.count()

}
