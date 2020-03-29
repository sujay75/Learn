package com.learn.datastructures;


public class Fibinocci {

    // 0 1 1 2 3 5 8 13
    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            System.out.println(rec(i));
        }
    }

    public static int rec(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1 || num == 2) {
            return 1;
        }
        return (rec(num - 1) + rec(num - 2));
    }
}
