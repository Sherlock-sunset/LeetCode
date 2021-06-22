package com.sherlock.lintcode;
//爬楼梯，斐波那契
public class LC_111 {
    public int climbStairs(int n) {
        // write your code here
        if(n<1) return 0;
        int [] dp = new int[2];
        dp[0] = 1;
        dp[1] = 2;
        if(n<=2) return dp[n-1];
        for(int i = 2; i < n;i++){
            int ans = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = ans;
        }


        return dp[1];
    }
}
