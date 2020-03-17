package com.learn.java;


public class StringImmutable {

    public static void main(String[] args) {
        String hello = "Hello";
        String hi = hello + "World";
        System.out.println(hi);
        hi = hello;
        System.out.println(hi);
        System.out.println(hello);

        String s1 = "1";
        String s2 = "2";
        s1 = s1.concat(s2);
        s2.concat("3");
        System.out.println("s1= " + s1 + " ,s2= " + s2);// s1=12 ,s2=2
        s2 = s2.concat("3");
        System.out.println("s2=" + s2);

        String name = "John";
        String newName = "John";
        String john = "Jo" + "hn";
        String myName = new String("John");
        System.out.println("name == newName=" + (name == newName));// true , object stored in string pool
        System.out.println("newName == john=" + (john == newName));// true , pick from string pool object and referred the same object
        System.out.println("john == name=" + (john == name));// true, pick from string pool object and referred the same object
        System.out.println("myName == name=" + (myName == name));// false since myName is not in string pool"

        System.out.println("myName.equals(name)=" + myName.equals(name));// here object value is being compared
        System.out.println("newName hashcode=" + System.identityHashCode(newName)); // 118352462
        System.out.println("name hashcode=" + System.identityHashCode(name));// 118352462
        System.out.println("john hashcode=" + System.identityHashCode(john));// 118352462
        System.out.println("myName hashcode=" + System.identityHashCode(myName));// 1550089733

        String str = "abc";
        String st1 = "ab";
        String st2 = st1 + "c"; // here it will not participate in string pool
        System.out.println("str==st1 = " + (str == st1));// false
        System.out.println("st1==st2 = " + (st1 == st2));// false
        System.out.println("str==st2 = " + (str == st2));// false
        System.out.println("str hashcode = " + System.identityHashCode(str));// 865113938
        System.out.println("st1 hashcode = " + System.identityHashCode(st1));// 1442407170
        System.out.println("st2 hashcode = " + System.identityHashCode(st2));// 1028566121

    }
}
