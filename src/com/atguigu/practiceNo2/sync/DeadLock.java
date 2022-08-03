package com.atguigu.practiceNo2.sync;

public class DeadLock {

    static Object o1 = new Object();
    static Object o2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (o1) {

                System.out.println(Thread.currentThread().getName() + "持有锁:o1,试图获取锁o2");

                synchronized (o2) {
                    System.out.println("获取到锁: o2");
                }
            }
        }, "AA").start();

        new Thread(() -> {
            synchronized (o2) {

                System.out.println(Thread.currentThread().getName() + "持有锁:o2,试图获取锁o1");

                synchronized (o1) {
                    System.out.println("获取到锁: o1");
                }
            }
        }, "BB").start();
    }
}
