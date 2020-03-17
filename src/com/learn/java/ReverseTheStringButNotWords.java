package com.learn.java;

public class ReverseTheStringButNotWords {

    public static void main(String[] args) {
        String input = "i.like.this.program.very.much \n" + "pqr.mno";
        System.out.println(input);
        String[] array = input.split("\\r?\\n");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            String[] temp = array[i].split("\\.");
            for (int j = temp.length - 1; j >= 0; j--) {
                sb.append(temp[j] + ".");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}
