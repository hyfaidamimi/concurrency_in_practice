package com.company.threadcoreknowledge.startthread;

/**
 * 描述：对比start和run两种线程启动方式
 */
public class StartAndRunMethod {

    public static void main(String[] args) {
        Runnable runnable=()->{
            System.out.println(Thread.currentThread().getName());
        };
        runnable.run();
        new Thread(runnable).start();
    }
}
