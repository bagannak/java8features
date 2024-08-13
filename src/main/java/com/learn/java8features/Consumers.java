package com.learn.java8features;

import java.util.Stack;
import java.util.function.Consumer;

record Student(int age, int rollNo, String name) {
    public Student editStudent(int age, int rollNo, String name){
        return new Student(age,rollNo,name);
    }
}

class MyConsumer implements Consumer<Student> {

    @Override
    public void accept(Student student) {
        System.out.println(student.name());
        System.out.println(student.rollNo());
        System.out.println(student.age());
    }
}

public class Consumers {
    public static void main(String[] args) {
        Student std1 = new Student(23, 235, "Baganna");

        MyConsumer myConsumer = new MyConsumer();
        myConsumer.accept(std1);

        Consumer<Student> studentConsumer =  s -> {
            Student student = s.editStudent(24, s.rollNo(), s.name());
            System.out.println("after editing");
            System.out.println(student.name());
            System.out.println(student.rollNo());
            System.out.println(student.age());
        };
        studentConsumer.accept(std1);

        //chaining
        System.out.println("__________________chaining____________________________");
        Consumer<Student> andThen = myConsumer.andThen(studentConsumer);

        andThen.accept(std1);
    }
}
