package com.sherlock.dynamic_programming;

/**
 * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
 * <p>
 * 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
 */
public class T1641 {
    public int countVowelStrings(int n) {
        if (n == 1)
            return 5;
        int[] dp = {1, 1, 1, 1, 1};
        for (int i = 1; i < n; i++) {
            dp[4] += dp[0] + dp[1] + dp[2] + dp[3];
            dp[3] += dp[0] + dp[1] + dp[2];
            dp[2] += dp[0] + dp[1];
            dp[1] += dp[0];
        }

        return dp[0] + dp[1] + dp[2] + dp[3] + dp[4];
    }
}
