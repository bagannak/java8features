package com.learn.java8features;

interface Math{
    int add(int a, int b);
    int sub(int a, int b);
    int mul(int a, int b);
    int div(int a, int b);

}
public class AnonymousInnerClass {

    public static void main(String[] args) {
        Math math = new Math() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }

            @Override
            public int sub(int a, int b) {
                return a - b;
            }

            @Override
            public int mul(int a, int b) {
                return a * b;
            }

            @Override
            public int div(int a, int b) {
                return a/b;
            }
        };
        System.out.println(math.add(1,6));
        System.out.println(math.sub(1,6));
        System.out.println(math.mul(1,6));
        System.out.println(math.div(1,6));
    }
}
