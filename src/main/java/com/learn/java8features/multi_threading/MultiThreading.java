package com.learn.java8features.multi_threading;

class MyThread extends Thread {
    @Override
    public void run() {

        System.out.println("RUNNING");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Child Thread");
        }

    }
}

public class MultiThreading {
    public static void main(String[] args) throws InterruptedException {
        //Child Threads
        //1st way
        MyThread myThread = new MyThread();
        System.out.println(myThread.getState());//checking the state of the thread(thread lifecycle NEW -> RUNNABLE -> RUNNING-> BLOCKED/WAITING-> TERMINATED).
        myThread.start();
        MyRunnable myRunnable = new MyRunnable();
        Thread t = new Thread(myRunnable);
        t.start();
        System.out.println(myThread.getState());
        Thread.sleep(100);

        System.out.println(myThread.getState());
        myThread.join();//main thread will wait until the myThread to die
        System.out.println(myThread.getState());

//        2nd way - this method is used to overcome the diamond problem in java(multiple inheritance)
//        MyRunnable myRunnable = new MyRunnable();
//        Thread t = new Thread(myRunnable);
//         t.start();


/*      instead of creating new class to implement a Runnable interface,
         we can use Lambda expression no need to create separate class(Runnable is functional interface).*/
/*        Runnable r = ()-> {
            for(int i=0; i<7;i++)
                System.out.println("2nd Child Thread");
            };
            new Thread(r).start();*/

//        Main Thread
        for (int i = 0; i < 7; i++) {
            System.out.println("Main Thread");
        }


    }
}
