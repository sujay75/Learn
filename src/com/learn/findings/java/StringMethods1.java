package com.learn.findings.java;


public class StringMethods1 {

    public static void main(String[] args) {

        String str = "java is object oriented language";
        System.out.println(str.length());// 32
        System.out.println(str.charAt(3));// a
        System.out.println(str.indexOf('i'));// 5
        System.out.println(str.indexOf("is"));// 5
        System.out.println(str.indexOf('o', 14));// 15
        System.out.println(str.indexOf("object", 4));// 8
        System.out.println(str.lastIndexOf('e'));// 31
        System.out.println(str.lastIndexOf("ed"));// 21

        System.out.println(str.substring(1));// ava is object oriented language
        System.out.println(str.substring(1, 5));// ava from index position 1 to endindex-1 i.e 5-1=4 the position.
        System.out.println("str.substring(1, 1) =" + str.substring(1, 1));// if both start and end indexes are same then we get empty value
        // System.out.println(str.substring(4, 1));// index out of bound exception

        String st = "java";
        st.toLowerCase();
        System.out.println(st);// java

        System.out.println("abc".equals("ABC"));// false
        System.out.println("abc".equalsIgnoreCase("ABC"));// true

        System.out.println(st.startsWith("j"));
        System.out.println(st.endsWith("v"));// false
        System.out.println(st.startsWith("J".toLowerCase()));// true
        System.out.println(st.replace('a', 'A'));// jAvA
}
}
