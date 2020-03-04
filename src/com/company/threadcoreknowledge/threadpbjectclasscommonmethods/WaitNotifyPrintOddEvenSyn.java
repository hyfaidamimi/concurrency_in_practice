package com.company.threadcoreknowledge.threadpbjectclasscommonmethods;

/**
 * 描述：两个线层交替打印0-100的奇偶数，用synchronized关键字实现
 */
public class WaitNotifyPrintOddEvenSyn {
    private static int count;
    private static final Object lock=new Object();
    //建两个线程
    //1个只处理偶数，第二个处理奇数（用位运算）
    //用synchronized来通信
    public static void main(String[] args) {
        count=0;
        new Thread(new Runnable() {
            @Override
            public void run() {

                while(count<100){
                    synchronized (lock){
                        if((count&1)==0){
                            System.out.println(Thread.currentThread().getName()+":"+count++);
                        }
                    }
                }
            }
        },"偶数线程").start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                while(count<100){
                    synchronized (lock){
                        if((count&1)!=0){
                            System.out.println(Thread.currentThread().getName()+":"+count++);
                        }
                    }
                }
            }
        },"奇数线程").start();
    }
}
