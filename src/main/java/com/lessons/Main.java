package com.lessons;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        startAtomicThreads();
        startVolatileThreads();

    }

    private static void startVolatileThreads() throws InterruptedException {
        Thread threadNumberOddSecond = new Thread(new SyncThreadNumber(0), "OddVolatile");
        Thread threadNumberEvenSecond = new Thread(new SyncThreadNumber(1), "EvenVolatile");
        threadNumberOddSecond.start();
        threadNumberEvenSecond.start();
        threadNumberOddSecond.join();
        threadNumberEvenSecond.join();
    }

    private static void startAtomicThreads() throws InterruptedException {
        Thread threadNumberOdd = new Thread(ThreadNumber.getNext(), "OddAtomic");
        Thread threadNumberEven = new Thread(ThreadNumber.getNext(), "EvenAtomic");
        threadNumberOdd.start();
        threadNumberEven.start();
        threadNumberEven.join();
        threadNumberOdd.join();
    }
}