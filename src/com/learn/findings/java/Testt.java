package com.learn.findings.java;


public class Testt {

    public static void main(String[] args) {
        int array[] = { 1, 0, 1, 0 };
        // i=0 , j=-1 1010
        // i=1 ,j=0 0110
        // i=2 , j=0 0110
        // i=3 ,j=1 0011
        int j = -1;

        for (int i = 0; i < array.length; i++) {
        if(array[i]==0) {
            j++;
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
        }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

}
