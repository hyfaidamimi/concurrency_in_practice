package com.company.threadcoreknowledge.threadpbjectclasscommonmethods;

/**
 * 描述：展示线程sleep的时候不释放synchronized的monitor。
 */
public class SleepDontReleaseMonitor implements  Runnable{
    public static void main(String[] args) {
        SleepDontReleaseMonitor m=new SleepDontReleaseMonitor();
        new Thread(m).start();
        new Thread(m).start();
    }
    @Override
    public void run() {
        syn();
    }

    private synchronized void syn(){
        System.out.println("线程"+Thread.currentThread().getName()+"获得了monitor。");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程"+Thread.currentThread().getName()+"退出了同步代码块");
    }
}
