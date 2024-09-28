package com.dorjear.training.fundamental.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class MinimumSwaps {
    public static int minimumSwaps(int[] arr) {
        int n = arr.length;
        int swaps = 0;

        // Create a list to track visited elements
        List<Boolean> visited = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            visited.add(false);
        }

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            // If the element is already visited or in its correct position, continue
            if (visited.get(i) || arr[i] == i + 1) {
                continue;
            }

            // Find the cycle size
            int cycleSize = 0;
            int j = i;
            while (!visited.get(j)) {
                visited.set(j, true);
                j = arr[j] - 1;
                cycleSize++;
            }

            // Update the number of swaps
            swaps += cycleSize - 1;
        }

        return swaps;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 2}; // Example array
        int minSwaps = minimumSwaps(arr);
        System.out.println("Minimum number of swaps: " + minSwaps);
    }
}