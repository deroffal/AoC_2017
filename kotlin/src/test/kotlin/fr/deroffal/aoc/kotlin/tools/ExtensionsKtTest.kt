package fr.deroffal.aoc.kotlin.tools

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class ExtensionsKtTest {

    @ParameterizedTest
    @CsvSource("1, '1'", "2, '2'", "3, '3'", "4, '4'", "5, '5'", "6, '6'", "7, '7'", "8,'8'", "9, '9'", "0, '0'")
    fun `Convert numeric char ton numeric value`(input: Char, output: Int) {
        assertEquals(output, input.getNumericValue())
    }

    @Test
    fun `getNumericValue when char is NaN throws IllegalArgumentException`() {
        assertThrows(IllegalArgumentException::class.java, {'a'.getNumericValue()})
    }

    @Test
    fun `Sort a word`(){
        assertEquals("abcdefgh", "bdfhaceg".sort())
    }

}