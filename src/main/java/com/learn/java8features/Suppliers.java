package com.learn.java8features;

import java.util.Date;
import java.util.function.Supplier;

class MySupplier implements Supplier<Date>{
    @Override
    public Date get(){
        return new Date();
    }
}

public class Suppliers {
    public static void main(String[] args) {
        MySupplier mySupplier = new MySupplier();
        System.out.println(mySupplier.get());

        Supplier<String> number =()-> "Baganna";

        System.out.println("--------"+number.get());


        Supplier<String> otpGenerator = () -> {
            String otp ="";

            for(int i=0; i <6; i++){
                otp += (int)(java.lang.Math.random() * 10);
            }
            return otp;
        };

        System.out.println("OTP : "+ otpGenerator.get());
    }
}
