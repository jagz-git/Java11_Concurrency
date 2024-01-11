package org.learning.concurrent_collections;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExamples {

    private static AtomicInteger ai = new AtomicInteger(0);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.submit(()-> System.out.println(ai.incrementAndGet()));
        }
        executorService.shutdown();
    }
//    Atomic Integer, Long and Boolean are thread safe classes that help in atomic operation, increment, decrement and add.
//    Few example methods: IncrementAndGet, GetAndIncrement, DecrementAndGet, GetAndDecrement, AddAndIncrement, IncrementAndAdd

}
