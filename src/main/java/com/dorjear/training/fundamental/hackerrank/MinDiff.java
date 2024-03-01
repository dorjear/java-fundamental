package com.dorjear.training.fundamental.hackerrank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MinDiff {

    // Counts the no of manipulations required
    public static int minDiff(List<Integer> arr) {
        int result = 0;
        arr.sort(Comparator.comparingInt(a -> a));
        Iterator<Integer> i = arr.iterator();
        if(!i.hasNext()) return result;
        int base = i.next();
        while(i.hasNext()){
            int next = i.next();
            result += Math.abs(next-base);
            base = next;
        }
        return result;
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
        List<Integer> input = Arrays.asList(1,3,3,2,4);
//        minDiff(input);
        System.out.println(minDiff(input));
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
