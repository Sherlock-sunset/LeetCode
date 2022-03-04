package com.sherlock.offer;

public class Day9 {
    /**
     * 剑指 Offer 42. 连续子数组的最大和
     * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     * 要求时间复杂度为O(n)。
     */
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE, last = 0;
        if (nums == null || nums.length < 1) return 0;
        for (int num : nums) {
            last = Math.max(last + num, num);
            ans = Math.max(ans, last);
        }
        return ans;
    }


    /**
     * 剑指 Offer 47. 礼物的最大价值
     * <p>
     * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
     * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
     * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
     */
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) return 0;
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = i - 1, y = j - 1;
                if (x < 0 && y < 0) dp[i][j] = grid[i][j];
                else if (x < 0) dp[i][j] = grid[i][j] + dp[i][y];
                else if (y < 0) dp[i][j] = grid[i][j] + dp[x][j];
                else dp[i][j] = grid[i][j] + Math.max(dp[x][j], dp[i][y]);
            }
        }
        return dp[n - 1][m - 1];
    }
}
