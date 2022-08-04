package com.atguigu.practiceNo2.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Demo1 {
    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        writeLock.lock();
        System.out.println("writeLock = " + writeLock);
        readLock.lock();
        System.out.println("readLock = " + readLock);
        writeLock.unlock();
        readLock.unlock();
    }
}
