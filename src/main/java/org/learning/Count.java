package org.learning;

public class Count {

    private static int counter = 0;

    public static  Object lock = new Object();//Don't create this object inside the synchronized block
//    If created inside the synchronized block it will treat as a new object every time and won't help in multithreading when acquiring the lock every time a thread needs.

    /* //Without synchronized
    private static void incrementCounter() {
        int current = counter;
        System.out.println("Before increment counter value: " + counter + "\tCurrent Thread id: " + Thread.currentThread().getId());
        counter = current + 1;
        System.out.println("After increment counter value:  " + counter + "\tCurrent Thread id: " + Thread.currentThread().getId());
        System.out.println("---------");
    }*/

     //    Without lock Object
    /*private synchronized static void incrementCounter() {
        int current = counter;
        System.out.println("Before increment counter value: " + counter + "\tCurrent Thread id: " + Thread.currentThread().getId());
        counter = current + 1;
        System.out.println("After increment counter value:  " + counter + "\tCurrent Thread id: " + Thread.currentThread().getId());
        System.out.println("---------");
    }*/

    private static void incrementCounter() {
        synchronized (lock) {
            int current = counter;
            System.out.println("Before increment counter value: " + counter + "\tCurrent Thread id: " + Thread.currentThread().getId());
            counter = current + 1;
            System.out.println("After increment counter value:  " + counter + "\tCurrent Thread id: " + Thread.currentThread().getId());
            System.out.println("---------");
        }
    }

    /*private void incrementCounter() {
//        Can't use this keyword on static method inside synchronized block.
//        Here we are trying to have the lock at instance level instead of object level.
        synchronized (this) {
            int current = counter;
            System.out.println("Before increment counter value: " + counter + "\tCurrent Thread id: " + Thread.currentThread().getId());
            counter = current + 1;
            System.out.println("After increment counter value:  " + counter + "\tCurrent Thread id: " + Thread.currentThread().getId());
            System.out.println("---------");
        }
    }*/

    /* //Without threads
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            incrementCounter();
        }
    }*/
    /* //With Thread
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> incrementCounter());
            thread.start();
        }
    }*/

    /*public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> incrementCounter());
            thread.start();
        }
    }*/

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> new Count().incrementCounter());
            thread.start();
        }
    }


}
