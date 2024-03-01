package com.dorjear.training.fundamental.inheritance;

public class PinkLady extends Apple {
    private String name = "name2";

    @Override public String getName() {
        return name;
    }

    @Override public void setName(String name) {
        this.name = name;
    }
}
