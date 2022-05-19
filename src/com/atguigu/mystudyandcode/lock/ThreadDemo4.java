package com.atguigu.mystudyandcode.lock;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author DELL on 2022/5/1.
 * @version 1.0
 */
public class ThreadDemo4 {

    public static void main(String[] args) {

        //List<String> list = new ArrayList<>();
        //List<String> list = new Vector<>();

       // List<String> list = Collections.synchronizedList(new ArrayList<>());

    /*    CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            },String.valueOf(i)).start();

        }*/

        //HashSet<String> set = new HashSet<>();
/*
        Set<String> set = new CopyOnWriteArraySet<>();

        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println("set = " + set);
            },String.valueOf(i)).start();

        }
*/


        //HashMap<String, String> map = new HashMap<>();

        Map<String, String> map = new ConcurrentHashMap<>();

        for (int i = 0; i < 30; i++) {
            String key = String.valueOf(i);
            new Thread(()->{
                map.put(key, UUID.randomUUID().toString().substring(0, 8));
                System.out.println("map = " + map);
            },String.valueOf(i)).start();

        }

    }


}
