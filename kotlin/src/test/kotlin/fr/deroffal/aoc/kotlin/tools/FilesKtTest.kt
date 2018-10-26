package fr.deroffal.aoc.kotlin.tools

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class FilesKtTest {

    @Test
    fun `Read file with only one line`() {
        assertEquals("Hello world!", readLine("file.txt"))
    }

    @Test
    fun `Read file with several lines`() {
        val lines = readLines("fileWithLines.txt")
        assertEquals(2, lines.size)

        assertEquals("Hello world!", lines[0])
        assertEquals("Bonjour le monde!", lines[1])
    }
}