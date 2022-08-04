package com.atguigu.practiceNo2.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo2 {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 10,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(3), new ThreadPoolExecutor.AbortPolicy());

        try {
            for (int i = 0; i < 10; i++) {
                threadPoolExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "执行任务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();
        }

    }
}
