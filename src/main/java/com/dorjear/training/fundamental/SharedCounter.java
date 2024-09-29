package com.dorjear.training.fundamental;

public class SharedCounter {
    private volatile int count = 0;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        SharedCounter a = new SharedCounter();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                a.increment();
            }
            System.out.println(Thread.currentThread().getName() + " finished. Count: " + a.getCount());
        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Final count: " + a.getCount());
    }
}