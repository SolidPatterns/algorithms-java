package com.solidpatterns.algodata.exercises;

import java.util.Arrays;

public class RecursiveSumArray {

    public int sum(int[] array) {
        if (array == null) throw new IllegalArgumentException("array cannot be null");

        if (array.length == 0) {
            return 0;
        }

        if (array.length == 1) {
            return array[0];
        }

        return array[0] + sum(Arrays.copyOfRange(array, 1, array.length));
    }
}
