package org.learning.Executorpackage;

import java.util.concurrent.*;

public class ScheduledPoolExample {
    private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(50);

    public static void main(String[] args) {
        Future<Double> doubleFuture = executorService.schedule(() -> {
            Thread.sleep((int)Math.random()*200);
            System.out.println(1 + " Thread id: " + Thread.currentThread().getId());
            return Math.random();
        }, 1000, TimeUnit.MILLISECONDS);

        try {
            System.out.println(doubleFuture.get(100, TimeUnit.MILLISECONDS));
//            System.out.println(doubleFuture.get());
//            Play around by commenting and uncommenting the above 2 lines and the catch clause TimeoutException
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
            doubleFuture.cancel(true);
        }
        if(doubleFuture.isCancelled()){
            System.out.println("Very Sorry, but future was cancelled.");
        }
        if(doubleFuture.isDone()){
            System.out.println("I am done !!");
        }
        executorService.shutdown();
    }

}
