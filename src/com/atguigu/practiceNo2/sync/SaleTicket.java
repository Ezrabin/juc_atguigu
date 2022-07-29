package com.atguigu.practiceNo2.sync;


class Ticket {

    private int num = 30;

    public synchronized void sale() {
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出:" + (num--) + "还剩:" + num);
        }
    }

}


public class SaleTicket {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }

        }, "AA").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }

        }, "BB").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }
            }

        }, "CC").start();

    }
}


