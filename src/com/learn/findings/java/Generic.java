package com.learn.findings.java;

import java.util.ArrayList;
import java.util.List;

public class Generic {

    public static void main(String[] args) {
        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        print(numberList);

        List<Float> numberList1 = new ArrayList<>();
        numberList1.add(1.1f);
        numberList1.add(2.2f);
        print(numberList1);

        List<Double> numberList2 = new ArrayList<>();
        numberList2.add(1.6d);
        numberList2.add(2.7d);

        print(numberList2);
        List numberList3 = new ArrayList<>();
        fillNumber(numberList3);
        print(numberList3);
    }

    private static void print(List<? extends Number> numberList) {
        for (Number num : numberList) {
            System.out.println(num);
        }
    }

    private static void fillNumber(List<? super Number> numberList) {
        numberList.add(Integer.MAX_VALUE);
        numberList.add(3);
    }

}
