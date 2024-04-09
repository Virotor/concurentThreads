package com.lessons;

import java.util.concurrent.atomic.AtomicInteger;

final public class ThreadNumber implements Runnable {

    static private final AtomicInteger count = new AtomicInteger();

    private final int initialValue;

    static private final AtomicInteger currentValue = new AtomicInteger();

    public ThreadNumber() {
        initialValue = count.getAndIncrement()%2;
    }

    public ThreadNumber(int startValue) {
        initialValue = startValue%2;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        String msg = " Thread name = " + thread.getName() + " Value = ";
        while (!thread.isInterrupted()) {
            if (currentValue.get() % 2 == initialValue) {
                System.out.println(msg + currentValue.getAndIncrement());
            }
        }

    }

}

