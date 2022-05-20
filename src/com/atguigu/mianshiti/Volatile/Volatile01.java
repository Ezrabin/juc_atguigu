package com.atguigu.mianshiti.Volatile;

import java.util.concurrent.TimeUnit;

/**
 * @author DELL on 2022/5/19.
 * @version 1.0
 */

// Volatile是Java虚拟机提供的轻量级的同步机制（三大特性）
// 保证可见性
// 不保证原子性
// 禁止指令重排

class MyData {

  int number = 0;

  public void addTo60() {
    this.number = 60;
  }
}

public class Volatile01 {
  public static void main(String[] args) {
    MyData myData = new MyData();

    new Thread(
            () -> {
              System.out.println(Thread.currentThread().getName() + "\t come in");
              try {
                TimeUnit.SECONDS.sleep(3);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
              myData.addTo60();
              System.out.println(Thread.currentThread().getName()+"\t update number value:"+myData.number);
            },
            "AAA")
        .start();
    
  }
}
