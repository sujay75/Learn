package com.learn.findings.java;


public class CompoundAssignment {

    public static void main(String[] args) {

        int x = 5;
        int y = 3;
        x *= y;
        System.out.println("x=" + x + " y=" + y);

        long l = 20;
        // x= x* l; //C.E
        x *= l;// here explicit casting not required. short for x= (int)(x*a);
        System.out.println("x=" + x);// 300

        long d = (x = 2);
        System.out.println("d=" + d + " x=" + x);// short form of x=2 and long d=x;

        int g = 1;
        int h = 2;
        int i = 4;
        int result = ++g * (h = 3) - (--i) + (i = i++);
        // g =2 , h=3, i=3
        //6-3+3 =6
        System.out.println("g=" + g + " h=" + h + " i=" + i + " result=" + result);
    }
}
