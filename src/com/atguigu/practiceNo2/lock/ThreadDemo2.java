package com.atguigu.practiceNo2.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Share2 {
    private int num = 0;

    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void add() throws InterruptedException {
        lock.lock();
        try {
            while (num != 0) {
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName() + " 加 1，num = " + num);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void remove() throws InterruptedException {
        lock.lock();
        try {
            while (num != 1) {
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName() + " 减 1，num = " + num);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}


public class ThreadDemo2 {
    public static void main(String[] args) {
        Share2 share2 = new Share2();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share2.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share2.remove();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share2.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "CC").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share2.remove();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "DD").start();
    }
}
