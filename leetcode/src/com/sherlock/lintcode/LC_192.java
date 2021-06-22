package com.sherlock.lintcode;

import java.util.HashMap;

public class LC_192 {
    /**
     * @param s: A string
     * @param p: A string includes "?" and "*"
     * @return: is Match?
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        char[] charP = p.toCharArray();
        if (s.isEmpty()) {
            for (int i = 0; i < charP.length; i++) {
                if (charP[i] != '*') return false;
            }
            return true;
        }
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        char[] charS = s.toCharArray();
        for (int i = 1; i <= p.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                if (charP[i - 1] == '*') {
                    dp[i][j] = dp[i - 1][i - 1 >= s.length() ? s.length() : i - 1];
                } else if (charP[i - 1] == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] && charP[i - 1] == charS[j - 1];
                }
            }
        }
        return dp[p.length()][s.length()];
    }


}
