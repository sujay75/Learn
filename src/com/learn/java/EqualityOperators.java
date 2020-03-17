package com.learn.java;


public class EqualityOperators {

    public static void main(String[] args) {
        // boolean g = true==4; C.E

        boolean x = true;
        boolean y = false;
        boolean z = (y = true) && (x = false);
        System.out.println("x=" + x);// false
        System.out.println("y=" + y);// true
        System.out.println("z=" + z);// false
        boolean c = (y != true) && (x = false);
        System.out.println("c=" + c);// false
        System.out.println("x=" + x);// false

    }
}
