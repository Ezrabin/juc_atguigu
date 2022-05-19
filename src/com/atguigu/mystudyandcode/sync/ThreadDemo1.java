package com.atguigu.mystudyandcode.sync;

/**
 * @author DELL on 2022/5/1.
 * @version 1.0
 */

class Share {
    private int number = 0;

    public synchronized void incr() throws InterruptedException {

        while (number != 0) {
            wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"::"+number);
        notifyAll();
    }

    public synchronized void decr() throws InterruptedException {
        while (number != 1) {
            wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"::"+number);
        notifyAll();
    }
}


public class ThreadDemo1 {

    public static void main(String[] args) {
        Share share = new Share();
        new Thread(()->{
            for (int i = 0; i <= 10; i++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"aa").start();

        new Thread(()->{
            for (int i = 0; i <= 10; i++) {
                try {
                    share.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"bb").start();

        new Thread(()->{
            for (int i = 0; i <= 10; i++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"cc").start();

        new Thread(()->{
            for (int i = 0; i <= 10; i++) {
                try {
                    share.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"dd").start();
    }




}
