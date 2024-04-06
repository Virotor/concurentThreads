package com.lessons;

import java.util.concurrent.atomic.AtomicInteger;

final public class ThreadNumber implements  Runnable{

    static private final AtomicInteger count = new AtomicInteger();

    private final int initialValue;

    static private final AtomicInteger currentValue = new AtomicInteger();

    public ThreadNumber(){
        initialValue = count.getAndIncrement()%2;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        while (!thread.isInterrupted()){
            synchronized (currentValue){
                if(currentValue.get()%2==initialValue){
                    try {
                        Thread.sleep(1000);
                        System.out.println(currentValue.getAndIncrement());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }

        }

    }
}
