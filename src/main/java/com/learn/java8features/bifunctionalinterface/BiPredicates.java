package com.learn.java8features.bifunctionalinterface;

import java.util.function.BiPredicate;

public class BiPredicates {
    public static void main(String[] args) {
        BiPredicate<Integer,Integer> p = (a, b) -> (a+b) % 10 == 0;

        System.out.println(p.test(10,30));
        System.out.println(p.test(12,5));
    }
}
