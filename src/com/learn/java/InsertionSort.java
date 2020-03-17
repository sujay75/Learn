
package com.learn.java;

public class InsertionSort {
    public static void main(String[] args) {
        int array[] = { 6, 4, 5, 7, 2, 1 };
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int temp = array[i];
            int j = i;

            while (j > 0 && temp < array[j - 1]) {
                array[j] = array[j - 1];
                j = j - 1;
            }
            //System.out.println("i=" + i + "j=" + j);

            array[j] = temp;
            print(array);
        }

    }

    private static void print(int[] array) {
        System.out.println();
        for (int l = 0; l < array.length; l++) {
            System.out.print(array[l] + ",");
        }
    }
}
