package fr.deroffal.aoc.kotlin

import fr.deroffal.aoc.kotlin.tools.readLines

fun main(args: Array<String>) {
    val input = readLines("day02.txt")
    val day02 = Day02()
    println("Part 1 : ${day02.solvePart1(input)}")
    println("Part 2 : ${day02.solvePart2(input)}")
}

class Day02 {
    internal fun solvePart1(input: List<String>): Int =
            parseInputToIntList(input)                  //parse to list of int list
                    .map { it.sorted() }                //sort each list
                    .map { it.last() - it.first() }     //subtract min to max
                    .sum()                              //add

    internal fun solvePart2(input: List<String>): Int =
            parseInputToIntList(input)
                    .map { findCandidates(it) }
                    .sumBy { it.first / it.second }

    private fun parseInputToIntList(input: List<String>) = input.map { it.split(" ").map { it.toInt() } }

    private fun findCandidates(row: List<Int>): Pair<Int, Int> =
            row.flatMap { int -> row.map { Pair(int, it) } }    //each number with each of the line
                    .filter { it.first != it.second }               //not twice the same
                    .first { it.first % it.second == 0 }            //find the firsts matching
}