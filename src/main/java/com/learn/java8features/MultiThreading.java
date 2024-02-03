package com.learn.java8features;

class MyRunnable implements Runnable{
    @Override
    public void run() {
        for(int i=0; i<7;i++) {
            System.out.println("Child Thread");
        }
    }
}

public class MultiThreading {
    public static void main(String[] args) {
        //Child Thread
        MyRunnable myRunnable = new MyRunnable();
        Thread t = new Thread(myRunnable);
         t.start();


         // instead of creating new class to implement a Runnable interface we can use Lambda expression no need to create separate class
        Runnable r = ()-> {
            for(int i=0; i<7;i++)
                System.out.println("2nd Child Thread");
        };
        new Thread(r).start();

        //Main Thread
         for(int i=0; i<7;i++){
             System.out.println("Main Thread");
         }
    }
}
