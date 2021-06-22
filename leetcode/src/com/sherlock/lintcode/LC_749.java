package com.sherlock.lintcode;

import java.util.HashMap;

public class LC_749 {
    public String isBuild(int x) {
        // write you code here
        boolean ans = false;
        //ans = trackBack(x,0);
        ans = dp(x);

        return ans ? "YES" : "NO";

    }

    private boolean dp(int x) {
        if (x < 7) return x == 3;

        boolean[] dp = new boolean[x];
        dp[2] = true;
        dp[6] = true;
        for (int i = 7; i < x; i++) {
            dp[i] = dp[i-3] || dp[i-7];
        }
        return dp[x-1];
    }

    private boolean trackBack(int x, int i) {
        if (i == x) return true;
        if (i > x) return false;
        return trackBack(x, i + 3) || trackBack(x, i + 7);
    }
}
