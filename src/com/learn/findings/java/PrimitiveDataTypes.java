package com.learn.findings.java;

public class PrimitiveDataTypes {

    public static void main(String[] args) {
        int ocatal = 010;// 8
        System.out.println(ocatal);
        System.out.println(Integer.toOctalString(ocatal)); // 10
        int hexa = 0x1ADE;// 4096+2560+208+14 =6878

        System.out.println(hexa);// 26
        System.out.println(Integer.toHexString(hexa));// 1ade
        int binary = 0b011;
        System.out.println(binary);// 3
        System.out.println(Integer.toBinaryString(binary));// 11

        float ff = 90.0f;
        System.out.println(ff);
        double doub = ff;
        System.out.println(doub);
        float f1 = 99_00.00f;
        // float f1 = 9900_.00f; CE
        System.out.println(f1);
        double dd = 10.3e2;
        System.out.println(dd);// 1030.0
        double dd1 = 10.3e02;
        System.out.println(dd1);// 1030.0
        double dd2 = 1030.0;

        double d = 0x3.e09894Fp3;
        System.out.println(d);
        double exponential = 0x4ce1;// 1249.0 // need to analyse
        System.out.println(exponential);

        char a = 't';
        System.out.println(a);
        char n = 123;
        System.out.println(n);
        int charnum = 'a';
        System.out.println(charnum);

    }
}
