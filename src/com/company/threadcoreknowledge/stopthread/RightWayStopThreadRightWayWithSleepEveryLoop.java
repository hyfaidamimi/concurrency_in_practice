package com.company.threadcoreknowledge.stopthread;

/**
 * 描述:每次循环都阻塞停止方法，不需要每次迭代都检查是否需要响应中断
 */
public class RightWayStopThreadRightWayWithSleepEveryLoop {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable=()->{
            int num=0;
            try {
                while(num<=10000){
                    if(num%100==0){
                        System.out.println(num+"是100的倍数");
                    }
                    num++;
                    Thread.sleep(10);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread=new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
