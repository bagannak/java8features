package com.learn.java8features.bifunctionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

class Employee1 {
    String name;
    double salary;

    public Employee1(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}

public class BiConsumers {
    public static void main(String[] args) {

        List<Employee1> list = new ArrayList<>();
        BiFunction<String, Double, Employee1> function = Employee1::new;

        list.add(function.apply("Baganna", 20000.0));
        list.add(function.apply("Sharat", 15000.0));
        list.add(function.apply("Roshan", 50000.0));
        list.add(function.apply("Alfa", 34000.0));

        BiConsumer<Employee1, Double> biConsumer = (employee1, salary) -> employee1.salary += salary;

        list.forEach((e) -> {
            biConsumer.accept(e, 5000.0);
            System.out.println(e.salary);
        });
    }
}
