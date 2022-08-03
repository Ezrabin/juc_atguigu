package com.atguigu.practiceNo2.lock;


import java.util.Collection;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareResource {
    //线程标志位
    private int falg = 1;

    private Lock lock = new ReentrantLock();

    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    //打印5次 loop第几轮
    public void print5(int loop) throws InterruptedException {
        lock.lock();
        try {
            while (falg != 1) {
                c1.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "打印i:" + i + ",第几轮:" + loop);
            }
            falg = 2;
            c2.signal();
        } finally {
            lock.unlock();
        }
    }

    //打印10次 loop第几轮
    public void print10(int loop) throws InterruptedException {
        lock.lock();
        try {
            while (falg != 2) {
                c2.await();
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "打印i:" + i + ",第几轮:" + loop);
            }
            falg = 3;
            c3.signal();
        } finally {
            lock.unlock();
        }
    }

    //打印15次 loop第几轮
    public void print15(int loop) throws InterruptedException {
        lock.lock();
        try {
            while (falg != 3) {
                c3.await();
            }
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "打印i:" + i + ",第几轮:" + loop);
            }
            falg = 1;
            c1.signal();
        } finally {
            lock.unlock();
        }
    }
}


public class ThreadDemo3 {

    public static void main(String[] args) {

        ShareResource shareResource = new ShareResource();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    shareResource.print5(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    shareResource.print10(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    shareResource.print15(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "CC").start();
    }
}
