package com.lessons;

public class Main {
    public static void main(String[] args) {
        Thread threadNumberOdd = new Thread(new ThreadNumber(), "Odd");
        Thread threadNumberEven = new Thread(new ThreadNumber(), "Even");
        Thread threadNumberOddSecond = new Thread(new SyncThreadNumber(0), "Odd2");
        Thread threadNumberEvenSecond = new Thread(new SyncThreadNumber(1), "Even2");
        threadNumberOdd.start();

       threadNumberEven.start();
//        threadNumberEvenSecond.start();
//        threadNumberOddSecond.start();
    }
}