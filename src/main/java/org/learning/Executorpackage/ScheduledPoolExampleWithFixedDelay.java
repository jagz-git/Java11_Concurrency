package org.learning.Executorpackage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledPoolExampleWithFixedDelay {

    private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(50);

    public static void main(String[] args) {
        int i = 0;
        executorService.scheduleWithFixedDelay(
                () -> {
                    System.out.println(i + "\tThread id: "+ Thread.currentThread().getId());
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                },
                2000, 100, TimeUnit.MILLISECONDS
        );

//        executorService.shutdown();
//          With the given time delay the shutdown method will be called so you wont see any input.
//        instead use awaitTermination method.

        try {
            executorService.awaitTermination(500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
