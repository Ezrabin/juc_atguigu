package com.atguigu.practiceNo2.juc;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    public static void main(String[] args) {
        //6辆汽车停三个停车位

        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i <= 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "停车");
                    //随机停车时间
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                    System.out.println(Thread.currentThread().getName() + "离开");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    //释放
                    semaphore.release();
                }
            }, "线程" + i).start();

        }
    }
}
