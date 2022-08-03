package com.atguigu.practiceNo2.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread1 implements Runnable {
    @Override
    public void run() {
        System.out.println("MyThread1");
    }
}

class MyThread2 implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("MyThread2");
        return 200;
    }
}


public class Demo1 {
    public static void main(String[] args) {
        new Thread(new MyThread1(), "AA").start();

        FutureTask<Integer> futureTask1 = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName() + "执行了");
            return 100;
        });
        FutureTask<Integer> futureTask2 = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName() + "执行了");
            return 200;
        });

        new Thread(futureTask2, "BB").start();
        new Thread(futureTask1, "AA").start();

//        while (!futureTask2.isDone()) {
//
//            System.out.println("waitingfutureTask2...");
//        }


        try {
            System.out.println("futureTask2.get() = " + futureTask2.get());
            System.out.println("futureTask1.get() = " + futureTask1.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("over = " + Thread.currentThread().getName());
    }

}