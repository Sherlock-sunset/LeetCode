package com.sherlock.lintcode;

/*
* 我们有一个栅栏，它有n个柱子，现在要给柱子染色，有k种颜色可以染。
必须保证不存在超过2个相邻的柱子颜色相同，求有多少种染色方案。
* */
public class LC_514 {
    /**
     * @param n: non-negative integer, n posts
     * @param k: non-negative integer, k colors
     * @return: an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        // write your code here
        int[] dp = new int[n+1];
        dp[0] = 0;
        if(n<1) return dp[n];
        dp[1] = k;
        if(n<2) return dp[n];
        dp[2] = k * k;

        for(int i=3 ;i <= n ; i++){
            dp[i] = dp[i-1] * (k-1) + dp[i-2] * (k-1);
        }

        return dp[n];
    }
}
