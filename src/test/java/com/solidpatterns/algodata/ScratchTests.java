package com.solidpatterns.algodata;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ScratchTests {

    @Test
    void test() {
//        permutation("abcd");
        System.out.println(fibonacci(4));
    }

    void permutation(String str) {
        permutation(str, "");
    }

    void permutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }

    int fibonacci(int n) {
        if (n <= 0) return 0;
        else if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}