package com.dorjear.example.fundamental.hackerrank;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class AnagramDelta {

    // Counts the no of manipulations required
    public static int numberNeeded(String first, String second) {
        if(first.length()!=second.length()) return -1;
        AtomicInteger count = new AtomicInteger();
        List<Character> a = first.chars().mapToObj(c -> (char) c).collect(Collectors.toList());;
        List<Character> b = second.chars().mapToObj(c -> (char) c).collect(Collectors.toList());;
        b.forEach(each -> {
            if(a.contains(each)){
                a.remove(each);
            }else{
                count.getAndIncrement();
            }

        });
        return count.intValue();
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
        String a = "aabcgt";
        String b = "abjjgh";
        System.out.println(numberNeeded(a, b));
    }

//    public static boolean isBalanced(String s) {
//        int len=s.length();
//        if(len==0 || s==null) return true;
//        Stack<Character> stack = new Stack<Character>();
//        for(int i=0;i<s.length();i++)
//        {
//            if(s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{')  stack.push(s.charAt(i));
//            else if(s.charAt(i)==')' && !stack.empty() && stack.peek()=='(') stack.pop();
//            else if(s.charAt(i)==']' && !stack.empty() && stack.peek()=='[') stack.pop();
//
//            else if(s.charAt(i)=='}' && !stack.empty() && stack.peek()=='{') stack.pop();
//            else return false;
//
//
//        }
//        return stack.empty();
//    }
//
//    public static void main(String[] args) {
//        String expression = "{{()}}";
//        System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
//    }

}
