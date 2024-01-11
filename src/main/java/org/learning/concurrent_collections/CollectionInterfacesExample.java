package org.learning.concurrent_collections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingQueue;

public class CollectionInterfacesExample {


    public static void main(String[] args) {
        ConcurrentMap<String, String> map = new ConcurrentHashMap<>();
        map.put("Lang", "Java");

        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        queue.offer("Sub");


    }

}
