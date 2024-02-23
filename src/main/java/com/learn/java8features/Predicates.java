package com.learn.java8features;

import java.util.function.Predicate;

class MyPredicate implements Predicate<Integer> {
    @Override
    public boolean test(Integer obj) {
        return obj % 10 == 0;
    }
}

public class Predicates {
    public static void main(String[] args) {
        MyPredicate myPredicate = new MyPredicate();
        int[] x = {0, 5, 10, 15, 20, 25, 30, 35};
        Predicate<Integer> p1 = i -> i % 2 == 0;
        Predicate<Integer> p2 = i -> i > 10;

        System.out.println(p1.test(64));
        System.out.println(myPredicate.test(4));


        //predicate joining add(), or(), negate()
        System.out.println("even number and greater than 10");
        for (int x1 : x) {
            if (p1.and(p2).test(x1)) {
                System.out.println(x1);
            }
        }

        System.out.println("even number or greater than 10");
        for (int x1 : x) {
            if (p1.or(p2).test(x1)) {
                System.out.println(x1);
            }
        }

        System.out.println("odd numbers");
        for (int x1 : x) {
            if (p1.negate().test(x1)) {
                System.out.println(x1);
            }
        }
    }
}
