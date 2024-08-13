package com.learn.java8features;

public class AnonymousInnerClassDemo2 {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) System.out.println("Child thread");
            }
        };
        Thread t = new Thread(runnable);
        t.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("Main Thread");
        }
    }

}
