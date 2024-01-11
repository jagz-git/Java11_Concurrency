package org.learning.concurrent_collections;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CollectionsProblem {

    public static void main(String[] args) {
        Map<String, String> stringStringMap = new HashMap<>();
//        Map<String, String> stringStringMap = new ConcurrentHashMap<>();
        stringStringMap.put("Man-12", "Java");
        stringStringMap.put("Man-121", "C#");
//        System.out.println(stringStringMap);

        for (Map.Entry entry: stringStringMap.entrySet()){
            System.out.println("Key: "+entry.getKey());
            System.out.println("Value: "+entry.getValue());
        }

        for (String key: stringStringMap.keySet()){
            System.out.println(key + " loves coding " + stringStringMap.get(key));
            stringStringMap.remove(key);
            //Exception in thread "main" java.util.ConcurrentModificationException
        }

    }

}
