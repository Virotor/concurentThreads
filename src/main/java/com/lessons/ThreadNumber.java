package com.lessons;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

final public class ThreadNumber implements Runnable {

    static private final AtomicInteger count = new AtomicInteger();


    static ReentrantLock semaphore = new ReentrantLock(true);

    private final int initialValue;

    static private final AtomicInteger currentValue = new AtomicInteger();

    public ThreadNumber() {
        initialValue = count.getAndIncrement() % 2;
    }

    public ThreadNumber(int startValue) {
        initialValue = startValue % 2;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        String msg = " Thread name = " + thread.getName() + " Value = ";
        while (!thread.isInterrupted()) {
            try {
                semaphore.lock();
                if (currentValue.get() % 2 == initialValue) {
                    System.out.println(msg + currentValue.getAndIncrement());
                }else{
                    System.out.println(msg + "wait");
                }
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally{
                semaphore.unlock();
            }
        }

    }

}

