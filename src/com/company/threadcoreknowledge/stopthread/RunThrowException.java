package com.company.threadcoreknowledge.stopthread;

/**
 * 描述：run无法抛出checkedException，只能有try/catch
 */
public class RunThrowException {
    public void  aVoid() throws Exception{

        throw new Exception();
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

    }
}
