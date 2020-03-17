package com.learn.java;


public class Factorial {

    public static void main(String[] args) {
        int num = 5;
        System.out.println(rec(num));
    }

    private static int rec(int numb) {

        if (numb == 0) {
            return 1;
        } else {
            return numb * rec(numb - 1);
        }
    }
}
