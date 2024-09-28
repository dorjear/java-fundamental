package com.dorjear.training.fundamental.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class MinimumBribes {

    public static void minimumBribes(List<Integer> q) {
        int bribes = 0;
        int n = q.size();

        for (int i = n - 1; i >= 0; i--) {
            if (q.get(i) - i - 1 > 2) {
                System.out.println("Too chaotic");
                return;
            }

            for (int j = i - 1; j >= Math.max(0, q.get(i) - 2); j--) {
                if (q.get(j) > q.get(i)) {
                    bribes++;
                }
            }
        }

        System.out.println(bribes);
    }

    public static void main(String[] args) {
        List<Integer> q1 = new ArrayList<>(List.of(1, 2, 3, 5, 4));
        List<Integer> q2 = new ArrayList<>(List.of(2, 1, 5, 3, 4));
        List<Integer> q3 = new ArrayList<>(List.of(5,1,2,3,7,8,6,4));

        minimumBribes(q1);
        minimumBribes(q2);
        minimumBribes(q3);
    }
}