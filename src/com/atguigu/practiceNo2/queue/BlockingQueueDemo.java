package com.atguigu.practiceNo2.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        // 创建一个阻塞队列
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
//        blockingQueue.add("a");
//        blockingQueue.add("b");
//        blockingQueue.add("c");
//       
//
//        System.out.println("blockingQueue.element() = " + blockingQueue.element());
//
//        System.out.println("blockingQueue.remove() = " + blockingQueue.remove());
//        System.out.println("blockingQueue.remove() = " + blockingQueue.remove());
//        System.out.println("blockingQueue.remove() = " + blockingQueue.remove());

//        System.out.println("blockingQueue.offer(\"a\") = " + blockingQueue.offer("a"));
//        System.out.println("blockingQueue.offer(\"b\") = " + blockingQueue.offer("b"));
//        System.out.println("blockingQueue.offer(\"c\") = " + blockingQueue.offer("c"));
//        System.out.println("blockingQueue.offer(\"d\") = " + blockingQueue.offer("d"));
//
//        System.out.println("blockingQueue.poll() = " + blockingQueue.poll());
//        System.out.println("blockingQueue.poll() = " + blockingQueue.poll());
//        System.out.println("blockingQueue.poll() = " + blockingQueue.poll());
//        System.out.println("blockingQueue.poll() = " + blockingQueue.poll());


//        blockingQueue.put("a");
//        blockingQueue.put("b");
//        blockingQueue.put("c");
//        //blockingQueue.put("d");
//        System.out.println("blockingQueue = " + blockingQueue);
//        blockingQueue.take();
//        blockingQueue.take();
//        blockingQueue.take();
//        //blockingQueue.take();


        blockingQueue.offer("a");
        blockingQueue.offer("b");
        blockingQueue.offer("c");
        blockingQueue.offer("d", 3L, TimeUnit.SECONDS);


    }
}
