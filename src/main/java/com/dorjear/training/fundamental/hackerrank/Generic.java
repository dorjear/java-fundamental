package com.dorjear.training.fundamental.hackerrank;

public class Generic<T> {
    private T value;
    public Generic(T value) {
        this.value = value;
    }
    public T getValue() {
        return value;
    }
}