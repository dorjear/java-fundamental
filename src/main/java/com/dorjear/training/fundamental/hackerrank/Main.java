package com.dorjear.training.fundamental.hackerrank;

import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        ArrayList<Generic<?>> g = new ArrayList<>();
        Generic<?> g1 = new Generic<>(10);
        Generic<?> g2 = new Generic<>("Hello");
        g.add(g1);
        g.add(g2);

        int i = g.get(0).getValue();
        String s = g.get(1).getValue();

        System.out.println(s);
        System.out.println(i);
    }
}