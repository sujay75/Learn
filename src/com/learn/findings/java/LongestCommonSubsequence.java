package com.learn.findings.java;


public class LongestCommonSubsequence {

    public static void main(String[] args) {
        getLCSLength("abcde", "abe");
        System.out.println();

    }


    public static int getLCSLength(String a, String b) {
        int m = a.length();
        int n = b.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("i=" + i + "j=" + j + ">> " + dp[i][j]);
            }
        }
        return dp[m][n];
    }
}
