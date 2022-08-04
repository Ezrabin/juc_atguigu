package com.atguigu.practiceNo2.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService pool1 = Executors.newFixedThreadPool(5);
        //ExecutorService pool1 = Executors.newSingleThreadExecutor();
        //ExecutorService pool1 = Executors.newCachedThreadPool();

        try {
            for (int i = 0; i < 10; i++) {
                pool1.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "执行任务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool1.shutdown();
        }

    }
}
