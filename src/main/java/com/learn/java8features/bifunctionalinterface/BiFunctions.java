package com.learn.java8features.bifunctionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

record Employee(int eno, String name) {
};

public class BiFunctions {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        BiFunction<Integer, String, Employee> function = (eno, name) -> new Employee(eno, name);

        list.add(function.apply(100, "Baganna"));
        list.add(function.apply(101, "Sharat"));
        list.add(function.apply(102, "Roshan"));
        list.add(function.apply(103, "Alfa"));

        System.out.println("Employee Number " + " Employee Name");
        for (Employee e : list) {
            System.out.print(e.eno()+ " ");
            System.out.print("             "+e.name());
            System.out.println();
        }
    }
}
