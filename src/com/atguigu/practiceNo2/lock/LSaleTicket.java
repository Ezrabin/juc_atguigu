package com.atguigu.practiceNo2.lock;


import java.util.concurrent.locks.ReentrantLock;

class LTicket {
    private int num = 30;

    private final ReentrantLock lock = new ReentrantLock();

    public void sale() {
        try {
            lock.lock();
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出:" + (num--) + "还剩:" + num);
            }
        } finally {
            lock.unlock();
        }

    }
}


/**
 * @author DELL on 2022/8/2.
 * @version 1.0
 */
public class LSaleTicket {


    public static void main(String[] args) {
        LTicket ticket = new LTicket();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "AA").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "BB").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "CC").start();
    }


}
