package org.learning;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Thread!");
        Thread t = new Thread(() -> System.out.println("Hi learners!\n" + "Runnable: " + Thread.currentThread().getName()));
        t.start();
        System.out.println("Main: " + Thread.currentThread().getId());

        CustomThread customThread = new CustomThread();
        customThread.start();

        Thread newThread = new Thread(new RunThread());
        newThread.start();

        //Using Lambda expression
        Thread t2 = new Thread(() -> System.out.println("Lambda Runnable!"));
        t2.start();

//        Callable

    }

}