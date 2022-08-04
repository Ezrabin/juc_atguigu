package com.atguigu.practiceNo2.juc;


import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "号同学离开了教室");
                    latch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "线程" + i).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "锁门走人");
    }
}
