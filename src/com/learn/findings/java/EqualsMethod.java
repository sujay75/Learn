package com.learn.findings.java;


public class EqualsMethod {

    public static void main(String[] args) {
        Integer i1 = 127;
        Integer i2 = 127; // Integer.valueOf(127);
        // Note: here comparing between references and not b/w values
        // here i1 value is cached (usually -127 to 128 allowed), so i1 memory address is assigned to i2
        System.out.println("i1==i2 " + (i1 == i2));// true
        System.out.println("i1 hash code=" + System.identityHashCode(i1));// 118352462
        System.out.println("i2 hash code=" + System.identityHashCode(i2));// 118352462

        System.out.println("128==128 " + (128 == 128));

        i1 = 128;// here the integer value is not cached.
        i2 = 128;// so i1 and i2 are having different memory addresses
        System.out.println("i1==i2 " + (i1 == i2));// false
        System.out.println("i1 hash code=" + System.identityHashCode(i1));// 1550089733
        System.out.println("i2 hash code=" + System.identityHashCode(i2));// 865113938

        Integer int1 = new Integer(1);
        Integer int2 = new Integer(1);
        Integer int3 = 1;

        System.out.println("int1 == int2 " + (int1 == int2));// false
        System.out.println("int1 == int3 " + (int1 == int3));// false
        System.out.println("int2 == int3 " + (int2 == int3));// false

        System.out.println("int1.equals(int2) =" + int1.equals(int2));// true
        System.out.println("int1.equals(int3) =" + int1.equals(int3));// true
        System.out.println("int2.equals(int3) =" + int2.equals(int3));// true
        
        Integer integerVal1 = 127;
        Integer integerVal2 =127;
        System.out.println("integerVal1==integerVal2 ="+ (integerVal1==integerVal2));
        
        System.out.println("integerVal1 hash code=" + System.identityHashCode(integerVal1));// 118352462
        System.out.println("integerVal2 hash code=" + System.identityHashCode(integerVal2));// 118352462
        integerVal1=10;
        System.out.println("integerVal1==integerVal2 ="+ (integerVal1==integerVal2));
        System.out.println("integerVal1 hash code=" + System.identityHashCode(integerVal1));// 1442407170
        System.out.println("integerVal2 hash code=" + System.identityHashCode(integerVal2));// 118352462
        


    }
}
