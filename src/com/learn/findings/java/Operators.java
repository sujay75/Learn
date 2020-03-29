package com.learn.findings.java;


public class Operators {

    public static void main(String[] args) {
        int a = 2 + 4 * 5 - 9 / 4;
        // 2+20-2
        // 20
        System.out.println("a=" + a);
        
        int b = 6/7-(4/3)+6*3+10;
        // 6/7-1+6*3+10
        // 0 -1+18+10
        //27
        System.out.println("b="+b);
        
        int c= 8%3-(8*4)+4/2-3/1;
        //8%3 - 32 + 4/2-3/1
        // 2-32+2-3
        //2-30-3
        //-31
        System.out.println("c="+c);
        
        double d = (2.5 *3.0)-6/4+3/4;
        //7.5 -6/4+3/4
        // 7.5 - 1+0
        //6.5
        System.out.println("d="+d);
    }

}
