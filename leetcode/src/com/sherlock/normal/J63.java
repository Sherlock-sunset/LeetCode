package com.sherlock.normal;

public class J63 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = Math.max(prices[1] - prices[0], dp[0]);
        int max = Math.max(dp[0], dp[1]);
        for (int i = 2; i < prices.length; i++) {
            dp[0] = dp[1];
            dp[1] = Math.max(0, dp[0] + prices[i] - prices[i - 1]);
            max = Math.max(dp[0], dp[1]);
        }

        return max;
    }
}
