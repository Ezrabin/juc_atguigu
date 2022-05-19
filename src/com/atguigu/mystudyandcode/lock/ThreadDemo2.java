package com.atguigu.mystudyandcode.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author DELL on 2022/5/1.
 * @version 1.0
 */

class Share {
    private int number = 0;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();


    public void incr() throws InterruptedException {
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "::" + number);
            condition.signalAll();
        } finally {
            lock.unlock();
        }


    }

    public synchronized void decr() throws InterruptedException {
        lock.lock();
        try {
            while (number != 1) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "::" + number);
            condition.signalAll();
        } finally {
            lock.unlock();
        }

    }
}

public class ThreadDemo2 {
    public static void main(String[] args) {

        Share share = new Share();
        new Thread(() -> {
            try {
                for (int i = 0; i <= 10; i++) {
                    share.incr();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "aa").start();


        new Thread(() -> {
            try {
                for (int i = 0; i <= 10; i++) {
                    share.decr();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "bb").start();

        new Thread(() -> {
            try {
                for (int i = 0; i <= 10; i++) {
                    share.incr();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "cc").start();


        new Thread(() -> {
            try {
                for (int i = 0; i <= 10; i++) {
                    share.decr();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "dd").start();

    }


}
