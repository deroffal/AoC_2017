package fr.deroffal.aoc.kotlin.tools

/** Convert a Char to its numeric value (subtract the ASCII code of 0). */
fun Char.getNumericValue() : Int = if (isDigit()) this - '0' else throw IllegalArgumentException("Cannot parse to number!")

/** Sort alphabetically a String.*/
fun String.sort() : String = String(toCharArray().sortedArray())