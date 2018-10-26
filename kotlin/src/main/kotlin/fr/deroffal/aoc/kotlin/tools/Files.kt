package fr.deroffal.aoc.kotlin.tools

import java.io.File
import java.io.FileNotFoundException

fun readLine(fileName: String): String = Thread.currentThread().contextClassLoader.getResource(fileName).readText()

fun readLines(fileName : String) : List<String> {
    val resource = Int::class.java.getResource(fileName) ?: throw FileNotFoundException("could not load '$fileName'")
    return File(resource.toURI()).readLines()
}