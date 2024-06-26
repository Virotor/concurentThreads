package com.lessons;

public class SyncThreadNumber implements Runnable {

    final int initialValue;
    final int nextValue;

    static volatile int currentValue = 0;
    static volatile int counter = 0;


    public SyncThreadNumber(int initialValue) {
        this.initialValue = initialValue % 2;
        this.nextValue = initialValue % 2 == 0 ? 1 : 0;
    }


    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        String msg = " Thread name = " + thread.getName() + " Value = ";
        while (!thread.isInterrupted()) {
            if (currentValue == initialValue) {
                System.out.println(msg + counter);
                int temp = counter;
                temp++;
                counter = temp;
                currentValue = nextValue;
            }
        }
    }
}
