package com.company.threadcoreknowledge.syn;

/**
 * 描述：静态加锁和非静态加锁
 */
public class SynchronizedStaticAndNormal8 implements Runnable{
    static SynchronizedStaticAndNormal8 instance=new SynchronizedStaticAndNormal8();
    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("Thread-0")){
            method2();
        }else {
            method1();
        }
    }

    public  synchronized static void method1(){
        System.out.println("我是静态加锁的方法"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    public synchronized void method2(){
        System.out.println("我是非静态加锁的方法"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    public static void main(String[] args) {
        Thread thread1=new Thread(instance);
        Thread thread2=new Thread(instance);
        thread1.start();
        thread2.start();
        while (thread1.isAlive()||thread2.isAlive()){}
        System.out.println("finished");
    }
}
