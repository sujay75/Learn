package com.learn.findings.java;


public class VariableScope {

    static int myInt = 20;
    double     myDouble = 40;
    public static void main(String[] args) {
        float myFloat = 20;

        {
            int myNum = 90;
            System.out.println("myInt=" + myInt);// 20
            System.out.println("myDouble=" + new VariableScope().myDouble);// 40.0
            System.out.println("myFloat=" + myFloat);// 20
            System.out.println("myNum=" + myNum);// 90

            {
                int myInsideInt = 80;
                System.out.println("myFloat=" + myFloat);// 10
                System.out.println("myNum=" + myNum);// 90
                System.out.println("myInsideInt=" + myInsideInt);// 80
            }
            // System.out.println("myInsideInt" + myInsideInt);// CE: variable cannot be resolved
        }
        System.out.println("myInt=" + myInt);// 20
        int myInt = 10;
        System.out.println("myInt=" + myInt);// 10
        System.out.println("myDouble=" + new VariableScope().myDouble);// 40.0
        int myInsideInt = 60;
        System.out.println("myInsideInt=" + myInsideInt);// 60

    }
}
