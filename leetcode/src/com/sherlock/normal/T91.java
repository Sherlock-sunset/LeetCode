package com.sherlock.normal;

public class T91 {
    public int numDecodings(String s) {
        if (s.isEmpty() || s.startsWith("0")) return 0;
        if (s.length() == 1) return 1;
        char[] c = s.toCharArray();
        int[] dp = new int[c.length];
        dp[0] = 1;
        dp[1] = toInt(c[0], c[1]);
        for (int i = 2; i < c.length; i++) {
            if ((c[i - 1] > '2' || c[i - 1] == '0') && c[i] == '0') return 0;
            else if (c[i - 1] == '0' || (c[i - 1] == '2' && c[i] > '6') || c[i - 1] > '2') dp[i] = dp[i - 1];
            else if (c[i] == '0') dp[i] = dp[i - 2];
            else dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[c.length - 1];

    }

    private int toInt(char n, char m) {
        if (n == '0') return 0;
        if (m == '0' && n > '2') return 0;
        if (m == '0' || n > '2') return 1;
        if (n == '2' && m > '6') return 1;
        return 2;
    }
}
