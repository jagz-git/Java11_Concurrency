package org.learning.concurrent_collections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ConcurrentBlockingQueue {

    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingQueue();
        queue.offer("Maria1");
        queue.offer("Maria2");
        queue.offer("Maria3");

        System.out.println(queue.peek()); //checks the first element but doesn't remove
        System.out.println(queue.poll()); //returns the first element and removes it
        System.out.println(queue.size());
        System.out.println(queue.contains("Maria3"));
        System.out.println(queue);

        //Special for concurrent queues
        try {
            queue.offer("Jim", 200, TimeUnit.MILLISECONDS);
            queue.poll(300, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(queue);
    }

}
