package com.learn.java8features;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class MyComparator implements Comparator<Integer> {
    public int compare(Integer obj1, Integer obj2) {
        return (obj1 < obj2) ? -1 : (obj1 > obj2) ? 1 : 0;
    }
}

class Employee {
    int eNo;
    String name;

    Employee(int eNo, String name) {
        this.eNo = eNo;
        this.name = name;
    }

    @Override
    public String toString() {
        return eNo + " : " + name;
    }
}

public class Comparators {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(38);
        list.add(18);
        list.add(36);
        list.add(25);
        list.add(3);
        list.add(8);
        list.add(5);

        System.out.println(list);

//        Collections.sort(list, new MyComparator()); or
        list.sort(new MyComparator());
        System.out.println("Ascending order: " + list);

//  using lambda expressions
        Comparator<Integer> comparator = (obj1, obj2) -> {
            if (obj1 > obj2) {
                return -1;
            } else if (obj1 < obj2) {
                return 1;
            }
            return 0;
        };
        list.sort(comparator);
        System.out.println("Descending order:" + list);

// Another example
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(234, "Baganna"));
        employees.add(new Employee(144, "Anush"));
        employees.add(new Employee(264, "Aman"));
        employees.add(new Employee(267, "Chetan"));
        employees.add(new Employee(345, "Ajay"));

        //sort By eNo
        employees.sort((obj1, obj2) -> obj1.eNo > obj2.eNo ? -1 : obj1.eNo < obj2.eNo ? 1 : 0);

        System.out.println("Sorted By eNo: " + employees);

        //sort By name

        Comparator<Employee> comparator1 = (e1, e2) -> e1.name.compareTo(e2.name);
        employees.sort(comparator1);
        System.out.println("Sorted By name: " + employees);
    }
}
