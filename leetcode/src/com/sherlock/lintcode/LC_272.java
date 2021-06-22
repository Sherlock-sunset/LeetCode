package com.sherlock.lintcode;

public class LC_272 {
    public int climbStairs2(int n) {
        // write your code here
        // write your code here
        if(n==0) return 1;
        int [] dp =new int[3];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = dp[0]+dp[1]+1;
        if(n<=3) return dp[n-1];
        for(int i = 3;i<n;i++){
            int ans = dp[0]+ dp[1]+dp[2];
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = ans ;
        }
        return dp[2];
    }
}
