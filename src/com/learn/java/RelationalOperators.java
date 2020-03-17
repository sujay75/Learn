package com.learn.java;


public class RelationalOperators {

    public static void main(String[] args) {
        int f = 4;
        boolean g = false && (f++ < 4);
        boolean h = (f-- == 4) && !g;
        System.out.println("f=" + f);// 3
        System.out.println("g=" + g);// false
        System.out.println("h=" + h);// true

        boolean x = true, z = false;
        int y = 20;
        x = (y != 10) ^ (z = false);// here intiliazing z to false again
        System.out.println("x=" + x + " y=" + y + " z=" + z);// x =true , y= 20 , z = false

    }

}
