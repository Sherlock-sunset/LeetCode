package com.sherlock.easy;

public class J10_2 {
    public int numWays(int n) {
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            int b = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = b % 1000000007;
        }
        return n <= 1 ? dp[0] : dp[1];
    }
}
