package com.learn.java8features;


@FunctionalInterface
interface DisplayMsg<T> {
    T displayMsg();
}

@FunctionalInterface
interface Operations {
    int operation(int a, int b);
}

public class FunctionalInterfaceLambdaExc {

    public int operate(int a, int b, Operations operations) {
        return operations.operation(a, b);
    }

    public static void main(String[] args) {
        Operations add = (a, b) -> {
            return a + b;
        };
        Operations sub = (a, b) -> a - b;
        Operations mul = (a, b) -> a * b;
        Operations div = (a, b) -> a / b;

        DisplayMsg<String> msg = () ->  "Hello Java lovers";

        FunctionalInterfaceLambdaExc exc = new FunctionalInterfaceLambdaExc();


        System.out.println("Addition: " + exc.operate(2, 5, add));
        System.out.println("Subtraction: " + exc.operate(2, 5, sub));
        System.out.println("Multiplication: " + exc.operate(2, 5, mul));
        System.out.println("Division: " + exc.operate(10, 2, div));
        msg.displayMsg();
    }
}
