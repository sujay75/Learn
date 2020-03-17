package com.learn.java;

import java.util.Arrays;

public class ReverseOnlyAlphabetsInaString {
    public static void main(String[] args) {
        String str = "S@U#%J*OP^A(;Y:";
        //            01234567891011
        //reverseOnlyAlphabets(str);// time space o(n2)
        reverAlphabetsOnly(str);
    }

    private static void reverAlphabetsOnly(String str) {
        char[] array = str.toCharArray();
        int l = 0, r = (array.length - 1);
        while (l < r) {
            if (!Character.isAlphabetic(array[l])) {
                l++;
            } else if (!Character.isAlphabetic(array[r])) {
                r--;
            } else {
                char temp = array[l];
                array[l] = array[r];
                array[r] = temp;
                l++;
                r--;
            }
        }
        System.out.println(String.valueOf(array));
    }

    private static void reverseOnlyAlphabets(String str) {
        char[] array = str.toCharArray();
        char[] alpha = new char[array.length - 1];
        //expected output  Y@A#OP%J*U(;S:
        int count = 0;
        int length = array.length - 1;
        for (int i = length; i >= 0; i--) {
            int ch = (int) array[i];
            if (ch >= 65 && ch <= 91) {
                alpha[count] = (Character) array[i];
                count++;
            }

        }
        count = 0;
        for (int i = 0; i <= length; i++) {
            int ch = (int) array[i];
            if (ch >= 65 && ch <= 91) {
                array[i] = alpha[count];
                count++;
            }

        }
        System.out.println(Arrays.toString(array));
    }
}
