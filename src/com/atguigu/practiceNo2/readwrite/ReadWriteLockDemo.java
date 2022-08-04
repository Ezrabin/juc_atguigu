package com.atguigu.practiceNo2.readwrite;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Mycache {

    private Map<String, String> map = new HashMap<>();

    private ReadWriteLock rwLock = new ReentrantReadWriteLock();


    //放入数据
    public void put(String key, String value) {

        rwLock.writeLock().lock();

        System.out.println(Thread.currentThread().getName() + "正在写入数据" + key + ":" + value);

        try {
            TimeUnit.MICROSECONDS.sleep(300);

            //写锁
            map.put(key, value);


            System.out.println(Thread.currentThread().getName() + "数据写完" + key + ":" + value);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    //取出数据
    public Object get(String key) {

        rwLock.readLock().lock();

        Object result = null;
        System.out.println(Thread.currentThread().getName() + "正在读取数据" + key);

        try {
            TimeUnit.MICROSECONDS.sleep(300);

            //读锁

            result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取数据完毕" + key);
            return result;

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            rwLock.readLock().unlock();
        }
    }
}

public class ReadWriteLockDemo {


    public static void main(String[] args) {
        Mycache mycache = new Mycache();

        //创建线程放数据
        for (int i = 1; i < 5; i++) {
            final int finalI = i;
            new Thread(() -> {
                mycache.put("key" + finalI, "value" + finalI);
            }, "线程" + i).start();
        }

        //创建线程取数据
        for (int i = 1; i < 5; i++) {
            final int finalI = i;
            new Thread(() -> {
                Object value = mycache.get("key" + finalI);
            }, "线程" + i).start();

        }

    }
}
