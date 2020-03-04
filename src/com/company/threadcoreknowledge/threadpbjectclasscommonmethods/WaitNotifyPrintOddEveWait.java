package com.company.threadcoreknowledge.threadpbjectclasscommonmethods;

/**
 * 描述：两个线层交替打印0-100奇偶数，用wait和notify
 */
public class WaitNotifyPrintOddEveWait {
    //1.拿到锁，我们就打印
    //2.打印完，唤醒其他线程，自己就休眠
    private static int count=0;
    private static final Object lock=new Object();


    public static void main(String[] args) throws InterruptedException {
        new Thread(new TurningRunner(),"偶数").start();
        Thread.sleep(100);
        new Thread(new TurningRunner(),"奇数").start();
    }
    static class TurningRunner implements Runnable{
        @Override
        public void run() {
            while(count<=100){
                synchronized (lock){
                    //拿到锁就打印
                    System.out.println(Thread.currentThread().getName()+":"+count++);
                    lock.notify();
                    if (count<=100){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
