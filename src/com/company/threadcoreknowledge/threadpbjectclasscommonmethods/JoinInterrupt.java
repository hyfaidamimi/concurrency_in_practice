package com.company.threadcoreknowledge.threadpbjectclasscommonmethods;

/**
 * 描述：演示join期间被中断的情况
 */
public class JoinInterrupt {
    public static void main(String[] args) {
        Thread mainThread=Thread.currentThread();
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mainThread.interrupt();
                    Thread.sleep(5000);
                    System.out.println("子线程结束");
                } catch (InterruptedException e) {
                    System.out.println("子线中断");
                }

            }
        });
        thread.start();
        System.out.println("等待子线程运行完毕");
        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+"主线程被中断了");
            e.printStackTrace();
            thread.interrupt();
        }
        System.out.println("子线程已经运行完毕");
    }
}
