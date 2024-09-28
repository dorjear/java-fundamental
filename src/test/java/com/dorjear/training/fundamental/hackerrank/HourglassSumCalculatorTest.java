package com.dorjear.training.fundamental.hackerrank;

import org.junit.jupiter.api.Test;

import static org.springframework.test.util.AssertionErrors.assertEquals;

import java.util.List;

public class HourglassSumCalculatorTest {

    @Test
    public void testHourglassSum() {
        List<List<Integer>> arr = List.of(
                List.of(1, 1, 1, 0, 0, 0),
                List.of(0, 1, 0, 0, 0, 0),
                List.of(1, 1, 1, 0, 0, 0),
                List.of(0, 9, 2, -4, -4, 0),
                List.of(0, 0, 0, -2, 0, 0),
                List.of(0, 0, -1, -2, -4, 0)
        );

        int expectedMaxSum = 13;
        int actualMaxSum = HourglassSumCalculator.hourglassSum(arr);

        assertEquals("The maximum hourglass sum should be 13", expectedMaxSum, actualMaxSum);
    }

    @Test
    public void testHourglassSumWithNegativeValues() {
        List<List<Integer>> arr = List.of(
                List.of(-9, -9, -9, -9, -9, -9),
                List.of(-9, -9, -9, -9, -9, -9),
                List.of(-9, -9, -9, -9, -9, -9),
                List.of(-9, -9, -9, -9, -9, -9),
                List.of(-9, -9, -9, -9, -9, -9),
                List.of(-9, -9, -9, -9, -9, -9)
        );

        int expectedMaxSum = -63;
        int actualMaxSum = HourglassSumCalculator.hourglassSum(arr);

        assertEquals("The maximum hourglass sum should be -63", expectedMaxSum, actualMaxSum);
    }
}
