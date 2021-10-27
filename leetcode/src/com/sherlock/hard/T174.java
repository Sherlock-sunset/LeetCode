package com.sherlock.hard;

public class T174 {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        int ans = 0;
        for (int i = 0; i < dungeon[0].length; i++) {
            //dp[0][i] = dungeon[0][i] + i > 0 ? dp[0][i - 1] : 0;
        }
        for (int i = 0; i < dungeon.length; i++) {
            //dp[i][0] = dungeon[i][0] + i > 0 ? dp[i-1][0] : 0;
        }
        for (int i = 1; i < dungeon.length; i++) {
            for (int j = 1; j < dungeon[0].length; j++) {
                //dp[i][j] = dungeon[i][j]+Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }

        return dp[dungeon.length][dungeon[0].length];
    }
}
