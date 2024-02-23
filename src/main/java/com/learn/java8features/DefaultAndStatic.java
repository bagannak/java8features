package com.learn.java8features;

interface Left{
    default void m1(){
        System.out.println("Left");
    }

    public static void m2(){
        System.out.println("Interface static method");
    }
}

interface Right{
    default void m1(){
        System.out.println("Right");
    }
}

interface Main extends Left{
    public static void main(String[] args) {
        System.out.println("Interface Main method");
        Left.m2();
    }
}
public class DefaultAndStatic implements Right,Left{
    @Override
    public void m1(){
        System.out.println("Namaste");
        Left.super.m1();
        Right.super.m1();
    }
    public static void main(String[] args) {
        DefaultAndStatic defaultAndStatic = new DefaultAndStatic();

        defaultAndStatic.m1();

        Left.m2();
    }
}
