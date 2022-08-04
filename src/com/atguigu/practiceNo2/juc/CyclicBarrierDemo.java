package com.atguigu.practiceNo2.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    private static final int NUM = 7;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(NUM, () -> {
            System.out.println(Thread.currentThread().getName() + "集齐7颗龙珠召唤神龙");
        });
        //集齐7
        for (int i = 1; i <= NUM; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "把龙珠放进龙珠盒");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }, "线程" + i).start();
        }
    }
}
