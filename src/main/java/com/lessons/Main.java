package com.lessons;

public class Main {
    public static void main(String[] args) {
        Thread threadNumberOdd = new Thread(new ThreadNumber());
        Thread threadNumberEven = new Thread(new ThreadNumber());
        Thread threadNumberOddSecond = new Thread(new ThreadNumber());
        Thread threadNumberEvenSecond = new Thread(new ThreadNumber());
        threadNumberOdd.start();
        threadNumberOddSecond.start();
        threadNumberEven.start();
        threadNumberEvenSecond.start();
    }
}