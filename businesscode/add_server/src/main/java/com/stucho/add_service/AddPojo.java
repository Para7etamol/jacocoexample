package com.stucho.add_service;

public class AddPojo {

    public int add(final int num1, final int num2) {

        if (num1 == 0 && num2 == 0) {

            System.out.println("Unnecessary computation ! ");
            return 0;
        } else {

            System.out.println("Processing...");
            return num1 + num2;
        }


    }
}