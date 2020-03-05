package com.company.threadcoreknowledge.threadpbjectclasscommonmethods;

/**
 * 描述：通过讲解join原理，分析join的代替写法
 */
public class JoinPrinciple {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread=Thread.currentThread();
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println(mainThread.getState());
                    System.out.println("Thread-0运行完毕");
                }catch (InterruptedException e){

                }
            }
        });
        thread.start();
        System.out.println("等待子线程运行完毕");
        //thread.join();
        synchronized (thread){
            thread.wait();
        }
        System.out.println("子线程运行完毕");
    }
}
