package com.atguigu.practiceNo2.sync;

class share {
    private int num = 0;

    public  void add() throws Exception {
        if (num != 0) {
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName() + "加1:" + num);
        this.notifyAll();
    }

    public  void sub() throws Exception{
        if (num != 1) {
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName() + "减1:" + num);
        this.notifyAll();
    }
}


/**
 * @author DELL on 2022/8/2.
 * @version 1.0
 */
public class ThreadDemo1 {

    //创建多个线程，每个线程都要执行add方法，每个线程都要执行sub方法
    public static void main(String[] args) {
        share share = new share();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.add();
                }catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, "AA").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    share.sub();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();
    }

}
