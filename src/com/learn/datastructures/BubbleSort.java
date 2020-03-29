package com.learn.datastructures;

public class BubbleSort {
    public static void main(String[] args) {

        int array[] = { 10, 3, 4, 7, 5, 1, 8, 2 };
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int k = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = k;
                }
            }

        }
        for (int l = 0; l < array.length; l++) {
            System.out.print(array[l] + ",");
        }
    }
}
