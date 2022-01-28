package com.solidpatterns.algodata.algorithms;

public class BinarySearch {

    public BinarySearch() {
    }

    public Integer search(int[] list, int item) {
        if (list == null || list.length == 0) throw new IllegalArgumentException("list cannot be null or empty.");

        int low = 0;
        int high = list.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = list[mid];

            if (guess == item) {
                return mid;
            }

            if (guess < item) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }
}
