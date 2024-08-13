package com.learn.java8features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

class MyFunction implements Function<Integer, List<Integer>> {//Function<T,R> T-input type, R- return type

    @Override
    public List<Integer> apply(Integer num) {
        List<Integer> digits = new ArrayList<>();
        while (num != 0){
            digits.add(num%10);
            num = num/10;
        }
        Collections.reverse(digits);
        return digits;
    }
}
public class Functions {
    public static void main(String[] args) {
        MyFunction function1 = new MyFunction();
        List<Integer> digits = function1.apply(23435);
        System.out.println(digits);

        //sum of digits
        Function<List<Integer>,Integer> function2 = (integers) -> integers.stream()
                .reduce(0, Integer::sum);
         Integer sumOfDigits = function2.apply(digits);
        System.out.println(sumOfDigits);


        //Function chaining


        // first function1 and then followed by function2 will apply
        Integer sumOfD = function1.andThen(function2).apply(23435);
        System.out.println("By function chaining -> " + sumOfD);


        // here first function2 and then followed by function1 will apply
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(3);
        list.add(5);
        List<Integer> sumOfD2 = function1.compose(function2).apply(list);

        System.out.println(sumOfD2);
    }
}
