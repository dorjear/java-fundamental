package com.dorjear.example.fundamental.inheritance;

import java.lang.reflect.Field;

public class ManTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        PinkLady m = new PinkLady();
        m.setName("aaa");
        System.out.println(m.getName());
        m.printName();

        Field f1 = m.getClass().getSuperclass().getDeclaredField("name");
        f1.setAccessible(true);
        f1.set(m, "bbb");
        m.printName();
    }
}
