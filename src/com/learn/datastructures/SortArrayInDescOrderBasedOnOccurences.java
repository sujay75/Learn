package com.learn.datastructures;

/**
 * 
 * Sort the input array into sorting order
 * create a 2D array value and occurences in one row
 * sort the array and print the elements
 *
 */
public class SortArrayInDescOrderBasedOnOccurences {

    public static void main(String[] args) {
        int arr[] = { 1, 3, 3, 4, 4, 4, 6, 6, 7, 8, 7, 6, 7, 4, 5, 7, 9, 7 };

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    //
                }
            }

        }

        print(arr);
        int x = 0;
        //create 2D array
        int array2[][]= new int[arr.length][2];
        array2[x][0] = arr[0];
        array2[x][1] = 1;
        for(int j=1;j<arr.length;j++) {
            if (arr[j] == arr[j - 1]) {
                array2[x][1] = array2[x][1] + 1;
            } else {
                x++;
                array2[x][0] = arr[j];
                array2[x][1] = 1;
            }

        }
        x++;
        System.out.println("x:" + x);
        int c[] = new int[2];
        for (int i = 0; i < x; i++) {
            for (int j = i; j < x; j++) {
                if (array2[i][1] < array2[j][1]) {
                    c = array2[i];
                    array2[i] = array2[j];
                    array2[j] = c;
                }
            }
        }
        printArray2(array2, x);
    }

    private static void print(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            // System.out.print(" ," + arr[j]);
        }
        System.out.println();
    }

    private static void printArray2(int[][] arr,int len) {
        for (int j = 0; j < len; j++) {
            for (int k = 0; k < arr[j][1]; k++) {
                System.out.print(arr[j][0]);
            // }

        }
        // System.out.println();
    }
    }
}
