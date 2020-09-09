package com.sherlock.dynamic_programming;

import com.sherlock.normal.T3;

import java.util.ArrayList;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * <p>
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class T5 {
    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.longestPalindrome("babad"));
        System.out.println(so.longestPalindrome(""));
        System.out.println(so.longestPalindrome("cbbd"));
        System.out.println(so.longestPalindrome("pwwkew"));
        System.out.println(so.longestPalindrome("pwwkw"));
        System.out.println(so.longestPalindrome("psdfhsa"));
    }

    /**
     * 官方解法2，动态规划 o（n2）,o(1)
     * 状态: dp[i][j]表示子串s[i...j]是否是回文
     * 状态转移方程:dp[i][j] = (s[i] == s[j]) and dp[i+1][j-1]
     **/
    public static class Solution2 {
        // 官方解法1，中心扩散方法 o（n2）,o(1)
        public String longestPalindrome(String s) {
            int len = s.length();
            if (len < 2)
                return s;

            int maxLen = 1;
            int begain = 0;
            boolean[][] dp = new boolean[len][len];
            for (int i = 0; i < len; i++) {
                dp[i][i] = true;
            }
            char[] chars = s.toCharArray();
            for (int j = 1; j < len; j++) {
                for (int i = 0; i < j; i++) {
                    if (chars[i] != chars[j]) {
                        dp[i][j] = false;
                    } else {
                        if (j - i < 3) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    }
                    if (dp[i][j] && j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        begain = i;
                    }
                }
            }
            return s.substring(begain, begain + maxLen);

        }

        //判断是不是回文字符串，s长度大小大于等于1
        public boolean isPalindrome(char[] chars, int pl, int pr) {
            while (pl < pr) {
                if (pl + 1 == pr)
                    break;
                pl++;
                pr--;
            }
            return true;
        }
    }

    public static class Solution {
        // 官方解法1，中心扩散方法 o（n2）,o(1)

        /**
         * 官方解法2，动态规划 o（n2）,o(1)
         * 状态: dp[i][j]表示子串s[i...j]是否是回文
         * 状态转移方程:dp[i][j] = (s[i] == s[j]) and dp[i+1][j-1]
         **/
        // 自己的解法,解题思路长度由大到小去寻找   o（n3），o（1）
        public String longestPalindrome(String s) {
            char[] chars = s.toCharArray();
            if (chars.length == 0)
                return "";
            for (int i = chars.length; i > 1; i--) {
                int pl = 0, pr = pl + i - 1;
                while (pr < chars.length) {
                    if (isPalindrome(chars, pl, pr))
                        return toStr(chars, pl, pr);
                    pl++;
                    pr++;
                }
            }
            if (chars.length % 2 == 0)
                return String.valueOf(chars[0]);
            else
                return toStr(chars, chars.length / 2, chars.length / 2);
        }

        //判断是不是回文字符串，s长度大小大于等于1
        public boolean isPalindrome(char[] chars, int pl, int pr) {
            while (pl < pr) {
                if (pl + 1 == pr)
                    break;
                pl++;
                pr--;
            }
            return true;
        }

        public String toStr(char[] chars, int pl, int pr) {
            StringBuilder sb = new StringBuilder();
            for (int i = pl; i <= pr; i++) {
                sb.append(chars[i]);
            }
            return sb.toString();
        }
    }
}
