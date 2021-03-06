package com.company.threadcoreknowledge.syn;

/**
 * 抛出异常后立刻释放锁
 */
public class SynchronizedException9 implements Runnable{
    static SynchronizedException9 instance=new SynchronizedException9();
    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("Thread-0")){
            method2();
        }else {
            method1();
        }
    }

    public  synchronized  void method1(){
        System.out.println("我是方法"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    public synchronized void method2(){
        System.out.println("我是非静态加锁的方法1"+Thread.currentThread().getName());
        try {
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
        //System.out.println(Thread.currentThread().getName()+"运行结束");
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
