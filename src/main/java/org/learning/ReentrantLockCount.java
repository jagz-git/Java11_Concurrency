package org.learning;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCount {
    private static int counter = 0;
    private static Lock lock = new ReentrantLock();

    private  static void incrementCount() {
        lock.lock();
        int current = counter;
        System.out.println("Before increment counter value: " + counter + "\tCurrent Thread Id: " + Thread.currentThread().getId());
        counter = current + 1;
        System.out.println("After increment counter value:  " + counter + "\tCurrent Thread Id: " + Thread.currentThread().getId());
        System.out.println("---------------------------------------------------------");
        lock.unlock();
    }

    private  static void incrementCountWithTryFinally() {
        try {
            lock.lock();
            int current = counter;
            System.out.println("Before increment counter value: " + counter + "\tCurrent Thread Id: " + Thread.currentThread().getId());
            counter = current + 1;
            System.out.println("After increment counter value:  " + counter + "\tCurrent Thread Id: " + Thread.currentThread().getId());
            System.out.println("---------------------------------------------------------");
        } finally {
            lock.unlock();
        }
    }

    private  static void incrementCountWithIfTryFinally() throws InterruptedException {
//        if(lock.tryLock()){ //If you dont specify the delay we are getting Exception and its expected as threads will now unlock but not be able to acquire the lock
        if(lock.tryLock(1000, TimeUnit.MILLISECONDS)){ //With time in milli sec
            try {
                int current = counter;
                System.out.println("Before increment counter value: " + counter + "\tCurrent Thread Id: " + Thread.currentThread().getId());
                counter = current + 1;
                System.out.println("After increment counter value:  " + counter + "\tCurrent Thread Id: " + Thread.currentThread().getId());
                System.out.println("---------------------------------------------------------");
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> incrementCount());
//            thread.start();
            Thread thread1 = new Thread(() -> incrementCountWithTryFinally());
//            thread1.start();
            Thread thread2 = new Thread(() -> {
                try {
                    incrementCountWithIfTryFinally();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread2.start();
        }
    }
}
