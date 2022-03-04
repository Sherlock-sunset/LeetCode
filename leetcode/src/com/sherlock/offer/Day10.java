package com.sherlock.offer;

import com.sherlock.data_structure.ListNode;

import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Day10 {
    /**
     * 剑指 Offer 46. 把数字翻译成字符串
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
     * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     */
    public int translateNum(int num) {
        char[] pass = String.valueOf(num).toCharArray();
        int[] dp = new int[pass.length];
        dp[0] = 1;
        for (int i = 1; i < pass.length; i++) {
            int n = Integer.parseInt(pass[i - 1] + "" + pass[i]);
            if (n >= 10 && n <= 25) {
                if (i == 1) {
                    dp[i] = 2;
                    continue;
                }
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }

        }

        return dp[pass.length - 1];
    }

    /**
     * 剑指 Offer 48. 最长不含重复字符的子字符串
     * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
     */
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        Queue<Character> queue = new LinkedList<>();
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (dic.getOrDefault(chars[i], false)) {
                while (!queue.isEmpty()) {
                    char c = queue.remove();
                    dic.put(c, false);
                    if (c == chars[i]) {
                        break;
                    }
                }
            }
            queue.add(chars[i]);
            dic.put(chars[i], true);
            ans = Math.max(queue.size(), ans);
        }

        return ans;

    }
}
