package com.lessons;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

final public class ThreadNumber implements Runnable {


    private static  final ThreadNumber ODD = new ThreadNumber(0);
    private static  final ThreadNumber EVEN = new ThreadNumber(1);
    private static final ReentrantLock reentrantLock = new ReentrantLock(true);
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int initialValue;
    static private final AtomicInteger currentValue = new AtomicInteger();
    private ThreadNumber(int startValue) {
        initialValue = startValue % 2;
    }

    public static ThreadNumber getNext(){
        return switch (count.getAndIncrement()%2)    {
            case 0->ODD;
            case 1->EVEN;
            default -> throw new IllegalStateException("Ошибка создания экземпляра класса...");
        };
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        String msg = " Thread name = " + thread.getName() + " Value = ";
        while (!thread.isInterrupted()) {
            try {
                reentrantLock.lock();
                if (currentValue.get() % 2 == initialValue) {
                    System.out.println(msg + currentValue.getAndIncrement());
                }else{
                    System.out.println(msg + "wait");
                }
                //Thread.sleep(100);
            } finally{
                reentrantLock.unlock();
            }
        }
    }
}

