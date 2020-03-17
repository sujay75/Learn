package com.learn.java;


public class WrapperClass {

    public static void main(String[] args) {

        Integer int1 = 10;
        Integer int2 = Integer.valueOf(10);
        Integer int3 = Integer.parseInt("10");
        Integer int4 = new Integer(10);
        Integer int5 = 10;

        System.out.println("int1=" + int1);
        System.out.println("int2=" + int2);
        System.out.println("int3=" + int3);
        System.out.println("int4=" + int4);
        System.out.println("int5=" + int5);

        Integer int6 = null;
        // int int7 = int6; CE : NPE, primitive doesnot hold the null
        // System.out.println("int7=" + int7);

        Integer int8 = 10;// boxing converting primitive to wrapper object
        System.out.println("int8=" + int8);
        int int9 = int1;// unboxing converting wrapper object to primitive type

    }

}
