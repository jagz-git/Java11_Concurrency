package org.learning.Executorpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleExecuteExample {

    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newSingleThreadExecutor(); //Single Thread Executor

//        getExecutorServiceSampleExample();
//        invokeAnyMethod();
        invokeAllMethod();
    }

    private static void getExecutorServiceSampleExample() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> System.out.println("1:" + Math.random() * 10 + "\tThread id: " + Thread.currentThread().getId()));
        executorService.execute(() -> System.out.println("2:" + Math.random() * 10 + "\tThread id: " + Thread.currentThread().getId()));
        executorService.execute(() -> System.out.println("3:" + Math.random() * 10 + "\tThread id: " + Thread.currentThread().getId()));
        executorService.execute(() -> System.out.println("4:" + Math.random() * 10 + "\tThread id: " + Thread.currentThread().getId()));
        executorService.shutdown();
    }

    private static void invokeAnyMethod() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Callable<Integer>> callables = new ArrayList<>();
        callables.add(() -> 1);
        callables.add(() -> 2);
        callables.add(() -> 3);
        callables.add(() -> 4);
        try {
            Thread.sleep(100);
            System.out.println(executorService.invokeAny(callables));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    private static void invokeAllMethod() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Callable<Integer>> callables = new ArrayList<>();
        callables.add(() -> 1);
        callables.add(() -> 2);
        callables.add(() -> 3);
        callables.add(() -> 4);
        try {
            Thread.sleep(100);
            System.out.println(executorService.invokeAll(callables));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }

}
