package com.solidpatterns.algodata.algorithms;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BinarySearchTest {

    private final BinarySearch binarySearch = new BinarySearch();

    private final int[] list = new int[1000000000];

    public BinarySearchTest() {
        Arrays.setAll(list, x -> x++);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 49, 66, 76, 99999999, 15, 29, 8899988})
    void if_it_finds_an_existing_integer(int item) {
        var expectedIndex = item;

        var result = binarySearch.search(list, item);

        assertAll("result",
                () -> assertNotNull(result),
                () -> assertEquals(expectedIndex, result)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -429, -66, -726, -100, 1999999999, -1925392})
    void if_it_returns_null_when_given_a_non_existing_integer(int item) {

        assertNull(binarySearch.search(list, item));
    }

    @Test
    void if_it_throws_invalid_argument_exception_when_passed_a_null_list() {
        assertThrows(IllegalArgumentException.class, () -> binarySearch.search(null, anyInt()));
    }

    @Test
    void if_it_throws_invalid_argument_exception_when_passed_an_empty_list() {
        assertThrows(IllegalArgumentException.class, () -> binarySearch.search(new int[0], anyInt()));
    }
}
