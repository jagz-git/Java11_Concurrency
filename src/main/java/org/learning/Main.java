package org.learning;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Thread!");
        Thread t = new Thread(() -> System.out.println("Hi learners!\n" + "Runnable: " + Thread.currentThread().getName()));
        t.start();
        System.out.println("Main: " + Thread.currentThread().getId());

        CustomThread customThread = new CustomThread();
        customThread.start();

        //Using Lambda expression
        Thread t2 = new Thread(() -> System.out.println("Lambda Runnable!"));
        t2.start();

        Thread newThread = new Thread(new RunThread());
        newThread.start();
//        newThread.interrupt();

        try {
            newThread.join(1500); //Remove 1500 and check you will see the difference
//            based on sleep time i.e. the waiting and the time specified the thread will wait and continue since join is called after 1.5 sec
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread newThread1 = new Thread(new RunThread());
        newThread1.start();


//        Callable

    }

}