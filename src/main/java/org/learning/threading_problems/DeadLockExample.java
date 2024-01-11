package org.learning.threading_problems;

public class DeadLockExample {

    private static void run() {

        final String resource1 = "stuck";
        final String resource2 = "forever";

        Thread thread1 = new Thread(
                () -> {
                    synchronized (resource1) {
                        System.out.println("Thread 1 has a lock on resource 1 - " + resource1);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (resource2) {
                            System.out.println("Thread1 has a lock on resource2");
                        }
                    }
                }
        );

        Thread thread2 = new Thread(
                () -> {
                    synchronized (resource2) {
                        System.out.println("Thread2 has a lock on resource 2 - " + resource2);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (resource1) {
                            System.out.println("Thread2 has a lock on resource 1");
                        }
                    }
                }
        );

//        To avoid the above deadlock use the code below
        /*Thread thread2 = new Thread(
                () -> {
                    synchronized (resource1) {
                        System.out.println("Thread2 has a lock on resource 1 - " + resource1);
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (resource2) {
                            System.out.println("Thread2 has a lock on resource 2");
                        }
                    }
                }
        );*/

//        start both the threads
        thread1.start();
        thread2.start();

    }

    public static void main(String[] args) {
        run();
    }

}
