package com.dorjear.training.fundamental.hackerrank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinimumSwapsTest {

    @Test
    void testMinimumSwaps() {
        assertEquals(3, MinimumSwaps.minimumSwaps(new int[]{4, 3, 1, 2}));
        assertEquals(3, MinimumSwaps.minimumSwaps(new int[]{2, 3, 4, 1, 5}));
        assertEquals(3, MinimumSwaps.minimumSwaps(new int[]{1, 3, 5, 2, 4, 6, 7}));
    }
}