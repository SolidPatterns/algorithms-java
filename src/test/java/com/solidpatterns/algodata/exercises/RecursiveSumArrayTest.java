package com.solidpatterns.algodata.exercises;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RecursiveSumArrayTest {

    private final RecursiveSumArray recursiveSumArray = new RecursiveSumArray();

    @Test
    void returns_correct_sum_when_given_an_array_of_10() {
        var array = new int[10];
        Arrays.setAll(array, x -> x++);

        var sum = recursiveSumArray.sum(array);
        assertEquals(((array.length - 1) * array.length) / 2, sum);
    }

    @Test
    void returns_correct_0_when_given_an_empty_array() {
        var sum = recursiveSumArray.sum(new int[]{});
        assertEquals(0, sum);
    }

    @Test
    void throws_illegal_argument_exception_when_given_null_array() {
        assertThrows(IllegalArgumentException.class, () -> recursiveSumArray.sum(null));
    }
}