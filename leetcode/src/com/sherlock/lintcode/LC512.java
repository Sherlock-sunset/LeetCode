package com.sherlock.lintcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class LC512 {
    /**
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // write your code here
        if (s.isEmpty()) return 0;
        char[] buffChars = s.toCharArray();

        int[] dp = new int[buffChars.length];
        dp[0] = isComposed(buffChars[0] + "") ? 1 : 0;
        if (buffChars.length < 2 || dp[0] == 0) return dp[0];
        dp[1] += isComposed(buffChars[1] + "") ? 1 : 0;
        dp[1] += isComposed(buffChars[0] + "" + buffChars[1]) ? 1 : 0;

        for (int i = 2; i < buffChars.length; i++) {
            dp[i] = 0;

            dp[i] += isComposed(buffChars[i] + "") ? dp[i - 1] : 0;
            if (dp[i] == 0 && !isComposed(buffChars[i - 1] + "")) return 0;
            dp[i] += isComposed(buffChars[i - 1] + "" + buffChars[i]) ? dp[i - 2] : 0;
            if (dp[i] == 0 && dp[i - 1] == 0) return 0;
        }
        return dp[buffChars.length - 1];
    }

    private boolean isComposed(String s) {
        if (s.startsWith("0")) return false;
        int num = Integer.parseInt(s);
        return num >= 1 && num <= 26;
    }
}
