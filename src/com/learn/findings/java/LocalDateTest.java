package com.learn.findings.java;

import java.time.LocalDate;

public class LocalDateTest {

    public static void main(String[] args) {
        LocalDate n1 = LocalDate.now();
        LocalDate n2 = LocalDate.now().atTime(1, 1).toLocalDate();
        LocalDate l1 = LocalDate.of(2019, 12, 18);
        LocalDate l2 = LocalDate.of(2019, 12, 18);
        System.out.println(l1.compareTo(l2));
        System.out.println(l1.isEqual(l2));
        System.out.println(n1.equals(n2));

    }
}
