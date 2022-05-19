package com.atguigu.mystudyandcode.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author DELL on 2022/5/1.
 * @version 1.0
 */
class LTicket {
    private int number = 30;

    private final ReentrantLock lock = new ReentrantLock();

    public void sale() {
        //上锁
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + " :卖出:" + (number--) + "剩下:" + number);
            }
        } finally {
            //解锁
            lock.unlock();
        }


    }
}


public class LSaleTicket {
    public static void main(String[] args) {

        LTicket lTicket = new LTicket();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                lTicket.sale();
            }
        }, "aa").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                lTicket.sale();
            }
        }, "bb").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                lTicket.sale();
            }
        }, "cc").start();

    }

}
