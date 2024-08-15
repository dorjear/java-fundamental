package com.dorjear.training.fundamental.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DescendingOrder {
    private static Long descendingOrderByPureNumberOperation(long input) {
        List<Long> theIntegerList = new ArrayList<>();
        while (input > 0) {
            theIntegerList.add(input % 10);
            input /= 10;
        }
        theIntegerList.sort(Comparator.naturalOrder());
        Double output = 0.0;
        int n = 0;
        for (Long l : theIntegerList) {
            output += l*Math.pow(10, n);
            n++;
        }
        return output.longValue();
    }

    private static Long descendingOrderByString(long input) {
        char[] charArray = String.valueOf(input).toCharArray();
        Arrays.sort(charArray);
        Double output = 0.0;
        int n = 0;
        for (char c : charArray) {
            output += (c-'0')*Math.pow(10, n);
            n++;
        }
        return output.longValue();
    }

    private static Long descendingOrderByStringStream(long input) {
        String outputString = String
                .valueOf(input)
                .chars()
                .mapToObj(c -> (char)c)
                .sorted(Comparator.reverseOrder())
                .map(Objects::toString)
                .collect(Collectors.joining());

        return Long.valueOf(outputString);
    }

    public static void main(String[] args){
        System.out.println(descendingOrderByPureNumberOperation(57875568));
        System.out.println(descendingOrderByString(57875568));
        System.out.println(descendingOrderByStringStream(57875568));
    }
}
