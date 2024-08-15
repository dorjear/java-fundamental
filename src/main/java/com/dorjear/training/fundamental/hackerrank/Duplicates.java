package com.dorjear.training.fundamental.hackerrank;

import java.util.Map;
import java.util.stream.Collectors;

public class Duplicates {
    private static long duplicateCount(String input) {
        return input
                .toLowerCase()
                .chars()
                .mapToObj(c -> (char) c)
                .collect(
                    Collectors.toMap(c -> c, c -> 1, Integer::sum)
                )
                .entrySet().stream().filter(entry -> entry.getValue()>=2).count();
    }

    public static void main(String[] args) {
        System.out.println(duplicateCount("abcde"));
        System.out.println(duplicateCount("aabbcde"));
        System.out.println(duplicateCount("aabBcde"));
        System.out.println(duplicateCount("indivisibility"));
        System.out.println(duplicateCount("Indivisibilities"));
    }
}
