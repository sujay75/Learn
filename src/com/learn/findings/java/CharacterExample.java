package com.learn.findings.java;


public class CharacterExample {

    public static void main(String[] args) {
        char ch1 = 'A';
        char ch2 = '1';
        System.out.println("ch1= " + ch1);//A
        System.out.println("ch1 is letter=" + Character.isLetter(ch1));//true
        System.out.println("ch1 is digit=" + Character.isDigit(ch1));//false

        System.out.println("ch2= " + ch2);//1
        System.out.println("ch2 is letter=" + Character.isLetter(ch2));//false
        System.out.println("ch2 is digit=" + Character.isDigit(ch2));//true

        char ch3 = 65;
        int i = ch3 + 10; // 'A' + 10 =75='K'
        char myNewChar = (char) i;
        System.out.println("i=" + i);// 75
        System.out.println("myNewChar= " + myNewChar);// K
        boolean b1 = (myNewChar == 'K');
        boolean b2 = myNewChar == (ch3 = 80);
        System.out.println("ch3= " + ch3);// P
        System.out.println("b1= " + b1);// true
        System.out.println("b2= " + b2);// false
        int charr = 'a';
        System.out.println("charr= " + charr);// 97

    }
}
