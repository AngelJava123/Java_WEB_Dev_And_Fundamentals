package com.company.Threads;

public class MyThread extends Thread {

    @Override
    public void run() {
        // if (this.isDaemon()) {
        //     System.out.println("This is daemon thread that is running");
        // }
        // System.out.println("This user thread that is running!");

        for (int i = 10; i > 0; i--) {
            System.out.println("Thread #1 : " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread #1 is finished");
    }
}
