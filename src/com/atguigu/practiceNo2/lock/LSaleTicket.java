package com.atguigu.practiceNo2.lock;


import java.util.concurrent.locks.ReentrantLock;

class LTicket{
    private int num = 30;

    private final ReentrantLock lock = new ReentrantLock();

    public  void sale() {
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出:" + (num--) + "还剩:" + num);
        }
    }
}









/**
 * @author DELL on 2022/8/2.
 * @version 1.0
 */
public class LSaleTicket {
}
