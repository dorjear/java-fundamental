package com.dorjear.training.fundamental.hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnagramUsingMap {

    public static boolean isAnagram(String s, String t) {
//        Map<Character,Integer> mapS = s.chars()
//                .mapToObj(c -> (char) c)
//                .collect(Collectors.toMap(
//                        c -> c,
//                        c -> 1,
//                        Integer::sum
//                ));
//        Map<Character,Integer> mapT = t.chars()
//                .mapToObj(c -> (char) c)
//                .collect(Collectors.toMap(
//                        c -> c,
//                        c -> 1,
//                        Integer::sum
//                ));
//
//        return mapS.equals(mapT);

//        List<Integer> sl = s.chars().sorted().mapToObj(Integer::valueOf).collect(Collectors.toList());
//        List<Integer> tl = t.chars().sorted().mapToObj(Integer::valueOf).collect(Collectors.toList());
//        return sl.equals(tl);

        if(s.length()!=t.length()) return false;
        int arr[] = new int[26];
        for(int i = 0; i < s.length(); i++){
            arr[s.toLowerCase().codePointAt(i)-'a'] ++;
            arr[t.toLowerCase().codePointAt(i)-'a'] --;
        }
        for(int i = 0; i < arr.length; i++){
            if (arr[i] !=0) return false;
        }

        return true;
    }

    public static void main(String[] args){
        System.out.println(isAnagram("rat", "car"));
    }
}
