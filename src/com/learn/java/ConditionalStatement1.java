package com.learn.java;


public class ConditionalStatement1 {

    public static void main(String[] args) {

        /*
         * while (true) {
         * System.out.println("true");
         * }
         */
         // endless loop

        int i = 10;

        while (i > 1) {
            i--;

        }
        System.out.println("i= " + i);
        int j=20;
        do {
            j--;
            System.out.println(j);
            while(j<10) {
                j--;
            }
            
        } while (j < 1);
        System.out.println("j= " + j);


        /*
         * for(;;)
         * 
         * {
         * System.out.println("hello"); // infinity loop
         * }
         * 
         */

        for (int a = 1, b = 2; a < 5 && b < 4; a++, b++) {
            System.out.println("test");
        }

        int z = 1;
        for (int a = 0, y = 1; a < 5 && z < 4; a++, z++) {
            System.out.println("a= " + a + " , b= " + z);

        }
        /*
         * for(int a=0,long z=0; a<5;a++) { same data type should be present
         * 
         * }
         */
    }
}
