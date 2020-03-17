package com.learn.java;


public class ConditionalStatement {

    public static void main(String[] args) {
        int x = 10;
        if (x == 10) {
            System.out.println("true");
        }

        if (true)
            System.out.println("test");
        else
            System.out.println("testtt");

        if ((x = 13) >= 10) {
            System.out.println("greater than");
        }
        
        int y=0;
        switch (y) {
        case 0:
            System.out.println("Monday");
            break;
        case 1: 
            System.out.println("Tuesday");
            break;
          default:
                System.out.println("other days");
                break;
        }

        int z = 0;
        switch (z) { // Note : if break is removed ,then all the values are displayed.
        case 0:
            System.out.println("Monday");// Monday
        case 1:
            System.out.println("Tuesday");// Tuesday
        default:
            System.out.println("other days");// othe days
        }

        int j = 65;
        switch (j) {
        case 'A':
        case 'E':
        case 'I':
        case 'O':
        case 'U':
            System.out.println("vowels");// here int value of 'A' is compared with 65 and prints the sysout
            break;
        default:
            System.out.println("consonants");
        }
                
           
    }

}
