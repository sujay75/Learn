
package com.learn.datastructures;

public class SelectionSort {

    public static void main(String[] args) {
        int array[] = { 10, 3, 4, 7, 5, 1, 8, 2 };
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[min]) {
                    min = j;//1

                }
            }
            int k = array[min];// k=1
            array[min] = array[i];//
            array[i] = k;
        }
        print(array);
    }

    private static void print(int[] array) {
        System.out.println();
        for (int l = 0; l < array.length; l++) {
            System.out.print(array[l] + ",");
        }
    }

}
