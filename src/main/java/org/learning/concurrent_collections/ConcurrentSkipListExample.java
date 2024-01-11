package org.learning.concurrent_collections;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class ConcurrentSkipListExample {

    public static void main(String[] args) {

        System.out.println("Both maintain natural order (ConcurrentSkipListSet & ConcurrentSkipListMap)\n");

        Set<String> set = new ConcurrentSkipListSet<>();
        set.add("Tim");
        set.add("Pascal");
        set.add("Elisa");
        set.add("John");

        for (String s : set){
            System.out.println(s);
        }

        System.out.println("");

        Map<String, String> map = new ConcurrentSkipListMap<>();
        map.put("Guitar", "Jesse");
        map.put("Bass", "Job");
        map.put("Piano", "Sietske");

        for (String s: map.keySet()){
            System.out.println(s + " played by " + map.get(s));
        }

    }

}
