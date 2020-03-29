package com.learn.findings.java;


public class DecAndInit {

    static int     myInt;
    static short   myShort;
    static char    myChar;
    static double  myDouble;
    static float   myFloat;
    static long    myLong;
    static byte    myByte;
    static boolean myBoolean;

    public static void main(String[] args) {
        int i;
        // System.out.println(i); //CE : variable not initialize
        i = 10;
        System.out.println(i);
        Double d1 = 10d, d2 = 20d;
        System.out.println(d1 + "," + d2);
        Double decimal1 = 10d, decimal2;
        // System.out.println(decimal1 + "," + decimal2); //CE : variable not initialize
        String st;
        if (true) {
            st = "true";
            System.out.println(st);
        } else {
            st = "false";
            System.out.println(st);
        }

        System.out.println("myInt=" + myInt);// 0
        System.out.println("myShort=" + myShort);// 0
        System.out.println("myChar=" + myChar);// space
        System.out.println("myDouble=" + myDouble);// 0.0
        System.out.println("myFloat=" + myFloat);// 0.0
        System.out.println("myLong=" + myLong);// 0
        System.out.println("myByte=" + myByte);// 0
        System.out.println("myBoolean=" + myBoolean);// false

    }
}
