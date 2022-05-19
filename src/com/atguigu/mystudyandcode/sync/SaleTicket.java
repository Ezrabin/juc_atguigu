package com.atguigu.mystudyandcode.sync;

/**
 * @author DELL on 2022/5/1.
 * @version 1.0
 */
class Ticket{
    private int number = 30;

    public synchronized void sale(){
        if(number>0){
            System.out.println(Thread.currentThread().getName()+" :卖出:"+(number--)+"剩下:"+number);
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
        },"aa").start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }

            }
        },"bb").start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 40; i++) {
                    ticket.sale();
                }

            }
        },"cc").start();
    }

}
