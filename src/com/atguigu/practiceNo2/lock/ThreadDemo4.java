package com.atguigu.practiceNo2.lock;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ThreadDemo4 {
    public static void main(String[] args) {
        //List<String> list = new ArrayList<String>();
        //List<String> list = new Vector<>();
        //List<String> list = Collections.synchronizedList(new ArrayList<String>());

        //并发读  独立写
        /*List<Object> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 10; i++) {

            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "当前:");
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }*/


        //HashSet<String> set = new HashSet<>();

      /*  Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 30; i++) {

            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "当前:");
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }*/

        //Map<String, String> map = new HashMap<>();
        Map<String, String> map = new ConcurrentHashMap<>();

        for (int i = 0; i < 30; i++) {

            String key = String.valueOf(i);
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "当前:");
                map.put(key, UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }

    }
}
