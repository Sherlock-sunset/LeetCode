package com.sherlock.normal;

public class T304 {
    public final int[][] matrix;
    public int[][] dp;

    public T304(int[][] matrix) {
        this.matrix = matrix;
        dp = new int[matrix.length][matrix[0].length];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < matrix.length; i++) {
            dp[0][i] = matrix[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < matrix[0].length; i++) {
            dp[i][0] = matrix[i][0] + dp[i - 1][0];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == row2 && col1 == col2) return dp[row1][col1];
        if (row1 == row2 && col1 == 0) return dp[row2][col2];
        if (col1 == col2 && row1 == 0) return dp[row2][col2];
        if (row1 == row2) return dp[row1][col2] - dp[row1][col1 - 1];
        if (col1 == col2) return dp[row2][col1] - dp[row1 - 1][col1];
        int ans = dp[row2][col2];
        if (row1>=1) ans-=dp[row1 - 1][col2];
        if (col1>=1) ans-=dp[row2][col1 - 1];
        if (row1>=1 && col1>=1) ans +=dp[row1 - 1][col1 - 1];
        return ans;
    }
}
