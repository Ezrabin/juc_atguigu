package com.atguigu.practiceNo2.sync;

import java.util.concurrent.TimeUnit;

class Phone {
    public synchronized void sendSMS() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("---------sendSMS---------");
    }

    public synchronized void sendEmail() {
        System.out.println("---------sendEmail---------");
    }

    public void getHello() {
        System.out.println("---------getHello---------");
    }
}


public class Lock_8 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "AA").start();
        Thread.sleep(100);
        new Thread(() -> {
            try {
                phone.sendEmail();
                //phone2.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "BB").start();
//        Thread.sleep(100);
//        new Thread(() -> {
//            phone.getHello();
//        }, "CC").start();
    }
}
