package com.company.threadcoreknowledge.threadpbjectclasscommonmethods;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 描述：每隔一秒输出当前时间，被中断，观察
 */
public class SleepInterrupted implements  Runnable{

    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new SleepInterrupted());
        thread.start();
        Thread.sleep(6500);
        thread.interrupt();
    }
    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println(new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("我被中断了");
                e.printStackTrace();
            }
        }
    }
}
