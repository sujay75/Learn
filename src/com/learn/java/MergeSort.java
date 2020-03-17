
package com.learn.java;

public class MergeSort {

    private static void mergeSort(int[] actual, int length) {
        if (length < 2) {
            return;
        }
        int middle = length / 2;
        int left[] = new int[middle];
        int right[] = new int[length - middle];
        for (int i = 0; i < middle; i++) {
            left[i] = actual[i];
        }
        for (int j = middle; j < length; j++) {
            right[j - middle] = actual[j];
        }
        mergeSort(left, middle);
        mergeSort(right, length - middle);
        merge(actual, left, right, middle, (length - middle));
    }

    private static void merge(int[] actual, int[] left, int[] right, int lefti, int righti) {
        int i = 0, j = 0, k = 0;
        while (i < lefti && j < righti) {
            if (left[i] <= right[j]) {
                actual[k++] = left[i++];
            } else {
                actual[k++] = right[j++];
            }
        }
        while (i < lefti) {
            actual[k++] = left[i++];
        }
        while (j < righti) {
            actual[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] actual = { 5, 1, 6, 2, 3, 4, 0 };
        MergeSort.mergeSort(actual, actual.length);
        for (int k = 0; k < actual.length; k++) {
            System.out.print("," + actual[k]);
        }
    }

}
