package com.learn.findings.java;


public class StringConcat {

    public static void main(String[] args) {
        int i = 9;
        int j = 10;
        System.out.println(i + j);// 19

        System.out.println(i + j + "test");// 19test
        System.out.println("test" + i + j);// test910
        System.out.println("test" + (i + j));// test19

        
        String hello = "Hello";
        String world ="World";
        String helloworld = hello + world;
        System.out.println(hello);
    }
}
