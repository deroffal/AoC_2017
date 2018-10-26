package fr.deroffal.aoc.kotlin

import java.util.*
import kotlin.math.absoluteValue
import kotlin.math.pow

fun main(args: Array<String>) {
    val input = fr.deroffal.aoc.kotlin.tools.readLine("day03.txt").toInt()
    val day03 = Day03()
    println("Part 1 : ${day03.solvePart1(input)}")
    println("Part 2 : ${day03.solvePart2(input)}")
}

data class Coordinate(val x: Int, val y: Int)

class Day03 {
    internal fun solvePart1(input: Int): Int {
        var coordinate = Coordinate(0, 0)

        var posX = 0
        var posY = 0

        var count = 0

        var step = 0
        while (count <= input) {
            val incOrDec = (-1.0).pow(step)
            var x = 0
            while (x < step && count <= input) {
                coordinate = Coordinate(posX, posY)
                x++
                count++
                posX += incOrDec.toInt()
            }
            var y = 0
            while (y < step && count <= input) {
                coordinate = Coordinate(posX, posY)
                y++
                count++
                posY += incOrDec.toInt()
            }
            step++
        }

        return coordinate.x.absoluteValue + coordinate.y.absoluteValue - 1
    }

    internal fun solvePart2(input: Int): Int {
        val coordinateByValue = HashMap<Coordinate, Int>()
        var coordinate = Coordinate(0, 0)
        coordinateByValue[coordinate] = 1

        var posX = 0
        var posY = 0

        var count = 1
        var step = 0
        while (count <= input) {
            val incOrDec = (-1.0).pow((step + 1))
            var x = 0
            while (x < step && count <= input) {
                posX += incOrDec.toInt()
                count = computeValueFromNeighbors(coordinateByValue, posX, posY)
                coordinate = Coordinate(posX, posY)
                coordinateByValue[coordinate] = count
                x++
            }
            var y = 0
            while (y < step && count <= input) {
                posY += incOrDec.toInt()
                count = computeValueFromNeighbors(coordinateByValue, posX, posY)
                coordinate = Coordinate(posX, posY)
                coordinateByValue[coordinate] = count
                y++
            }
            step++
        }
        return coordinateByValue[coordinate]!!
    }

    private fun computeValueFromNeighbors(coordinateByValue: Map<Coordinate, Int>, posX: Int, posY: Int): Int {
        return coordinateByValue.filter { (it.key.x in posX - 1..posX + 1) && (it.key.y in posY - 1..posY + 1) }.map { it.value }.sum()
    }
}