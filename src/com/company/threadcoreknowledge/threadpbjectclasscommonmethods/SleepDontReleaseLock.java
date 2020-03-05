package com.company.threadcoreknowledge.threadpbjectclasscommonmethods;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 描述：sleep不释放lock锁
 */
public class SleepDontReleaseLock implements Runnable{
private static final Lock lock=new ReentrantLock();
    @Override
    public void run() {
        lock.lock();
        System.out.println("线程"+ Thread.currentThread().getName()+"获取到了锁");
        try {
            Thread.sleep(5000);
            System.out.println("线程"+ Thread.currentThread().getName()+"被唤醒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SleepDontReleaseLock m=new SleepDontReleaseLock();
        new Thread(m).start();
        new Thread(m).start();
    }
}
