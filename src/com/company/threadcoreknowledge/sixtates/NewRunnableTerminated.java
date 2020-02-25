package com.company.threadcoreknowledge.sixtates;

/**
 * 描述：展示线程的new，runnable,terminated状态。即使是正在运行也是runnable状态，而不是running
 */
public class NewRunnableTerminated implements Runnable{

    public static void main(String[] args) {
        Thread thread=new Thread(new NewRunnableTerminated());
        //打印在new的状态
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        try {
            Thread.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(thread.getState());
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(thread.getState());
    }
    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            System.out.println(i);
        }
    }
}
