package com.learn.findings.java;


public class UnaryOperator {

    public static void main(String[] args) {
        int e = 10;
        int result = ++e * 40 / e-- - e++ / 3;
        // 11 * 40 /11 - 11/3
        // 40-3 = 41
        System.out.println("e=" + e + "result=" + result);

        int g = 6;
        int h = 2;
        int i = ++h + --g * 3 + 2 * g++ - h-- % --g;
        // 3 + 5 * 3 + 2 * 5 - 3 % 4
        // 3 + 15 + 10-3
        // g =5 , h=2
        System.out.println("g=" + g + " h= " + h + " i=" + i);

        short s = 10;
        short d = 20;
        short result1 = (short) (s * d);

        System.out.println(result1);
        // long l = 294949494949949494; C.E
        long l = 294949494949949494L;
        short r = (short) 9393939;
        System.out.println("r=" + r); // 22291 //due to overflow of limit.
        byte b1 = 10;
        byte b2 = 30;
        b1 = (byte) (b1 + b2);
        System.out.println("b1=" + b1);
        // b1= b1+1; C.E. cannot convert into to byte


    }
}
