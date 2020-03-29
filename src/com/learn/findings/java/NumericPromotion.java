package com.learn.findings.java;

public class NumericPromotion {
public static void main(String[] args) {
	// promotion : smaller to bigger type
	int x=5;
	double y=10.5;
	System.out.println("x+y="+ x+y);//510.5
        // Rule 1: when two values have differenet data types , java will auto promote one of the values to larger data type.

        System.out.println("x+y=" + (x + y));
        double result = x + y; // here bigger data type is double i.e y ..so converted to double
        // Rule 2 : When one of the value is integral and other is floating point then , java will auto promote
        // integral type(char,byte,short,int) to floating point (float or double)
        short s = 10;
        double d = 20;
        double sum = s + d;
        System.out.println("s + d=" + sum); // 30.0

        // Rule 3 : when adding either of the values of byte ,short ,int,char, then java auto promotes to int
        char ch = 'r';
        byte b = 127;
        short sh = 22;
        int sumof = ch + b + sh;
        System.out.println("sumof=" + sumof);// 263

        // Rule 4 : After all promotions finished and the operands are having same data type ,the result value have same data type.
        double d1 = 20;
        float f1 = 11;
        short s1 = 9;
        float f2 = s1 + f1;
        double d3 = f1 + f2 + d1;
        System.out.println("d3=" + d3);// 51.0

        // Type casting.

        double cast1 = b;// smaller data type assigning to bigger data type
        byte byt = (byte) 20.0;
        System.out.println("byt=" + byt);// 20

        double cast2 = 11.99;
        // int int2=4 + cast2;// C.E here bigger data type is double , so double cannot fit in int variable.
        int int2 = (int) (4 + cast2);
        System.out.println("int2=" + int2); // 15 and looses the precision value.

        // Questions
        double ddd = 39.9;
        // float fff = 30.9; C.E if floating precision is used then at the end of the numbers append with f or F otherwise compilation error.

}
}
