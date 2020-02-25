package com.company.threadcoreknowledge.startthread;

/**
 * 描述：不能两次调用start
 */
public class CantStartTiwce {

    public static void main(String[] args) {
        Thread thread=new Thread();
        thread.start();
        thread.start();
    }
}
