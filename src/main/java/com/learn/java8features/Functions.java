package com.learn.java8features;

import java.util.ArrayList;
import java.util.Collections;
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
        MyFunction myFunction = new MyFunction();
        List<Integer> digits = myFunction.apply(23435);
        System.out.println(digits);
        Function<List<Integer>,Integer> function2 = (integers) ->integers.stream().reduce(0, Integer::sum);
         Integer compose = function2.apply(digits);
        System.out.println(compose);
    }

}
