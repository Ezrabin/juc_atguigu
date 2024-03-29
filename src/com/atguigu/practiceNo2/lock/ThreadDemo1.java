package com.atguigu.practiceNo2.lock;

class Share {
    private int num = 0;

    public synchronized void add() throws InterruptedException {
        while (num != 0) {
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName() + " 加 1，num = " + num);
        this.notifyAll();
    }

    public synchronized void remove() throws InterruptedException {
        while (num != 1) {
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName() + " 减 1，num = " + num);
        this.notifyAll();
    }
}


public class ThreadDemo1 {

    public static void main(String[] args) {
        //
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
