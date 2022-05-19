package com.atguigu.mystudyandcode;

/**
 * @author DELL on 2022/5/1.
 * @version 1.0
 */
public class Mian {
    public static void main(String[] args) {

        Thread aa = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "::" + Thread.currentThread().isDaemon());
            while (true) {

            }
        }, "aa");
        aa.setDaemon(true);
        aa.start();

        System.out.println(Thread.currentThread().getName()+"over");
    }
}
