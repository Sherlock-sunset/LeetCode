package com.sherlock.normal;

public class J47 {
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        int max = dp[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
            max = dp[0][i];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j == 0) dp[i][j] = dp[i - 1][j] + grid[i][j];
                else dp[i][j]= Math.max(dp[i - 1][j],dp[i][j-1]) + grid[i][j];
                max = Math.max(dp[i][j],max);
            }
        }
        return max;
    }
}
