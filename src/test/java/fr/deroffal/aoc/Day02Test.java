package fr.deroffal.aoc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day02Test {

    @Test
    void input5195_retourne_8() {
        assertEquals(8, Day02.calculerDifference("5\t1\t9\t5"));
    }

    @Test
    void input753_retourne_4() {
        assertEquals(4, Day02.calculerDifference("7\t5\t3"));
    }

    @Test
    void input2468_retourne_6() {
        assertEquals(6, Day02.calculerDifference("2\t4\t6\t8"));
    }

    @Test
    void input5928_retourne_4() {
        assertEquals(4, Day02.calculerDifferenceDivision("5\t9\t2\t8"));
    }

    @Test
    void input9473_retourne_3() {
        assertEquals(3, Day02.calculerDifferenceDivision("9\t4\t7\t3"));
    }

    @Test
    void input3865_retourne_2() {
        assertEquals(2, Day02.calculerDifferenceDivision("3\t8\t6\t5"));
    }

}
