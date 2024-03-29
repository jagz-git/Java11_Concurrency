package org.learning.concurrent_collections;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteExample {

    public static void main(String[] args) {

        List<String> list = new CopyOnWriteArrayList<>();
        list.add("Squirrel");
        list.add("Mouse");
        list.add("Hamster");

        for (String s : list){
            System.out.println(s);
            list.add(s);
//            This doesn't create an infinite loop. A copy of the list is created everytime the object is modified, so it won't alter the original object
        }

        System.out.println(list);

        Set<String> set = new CopyOnWriteArraySet<>();
        set.add("Dog");
        set.add("Cat");
        set.add("Horse");

        for (String s : set){
            System.out.println(s);
            set.add(s);
        }

        System.out.println(set);

    }

}
