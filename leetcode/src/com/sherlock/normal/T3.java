package com.sherlock.normal;

import java.util.ArrayList;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class T3 {
    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.lengthOfLongestSubstring("dvdf"));
        System.out.println(so.lengthOfLongestSubstring("bbbbb"));
        System.out.println(so.lengthOfLongestSubstring("pwwkew"));
    }

    public static class Solution {
        /**
         * 用队列实现
         * 这题主要是进队出队的思想
         */
        public int lengthOfLongestSubstring(String s) {
            int maxLen = 1;
            char[] charsStr = s.toCharArray();
            if (charsStr.length == 1)
                return 1;
            else if (charsStr.length == 0)
                return 0;

            ArrayList<Character> enqueue = new ArrayList<>();
            enqueue.add(charsStr[0]);

            for (int i = 1, temp = 1; i < charsStr.length; i++) {


                if (!enqueue.contains(charsStr[i])) {
                    //进队
                    if (++temp > maxLen)
                        maxLen = temp;
                    enqueue.add(charsStr[i]);
                } else {
                    while (enqueue.get(0) != charsStr[i]) {
                        //出队
                        enqueue.remove(0);
                    }
                    enqueue.remove(0);//不要漏了这句
                    enqueue.add(charsStr[i]);
                    temp = enqueue.size();
                }
//                System.out.println(charsStr[i] + "   temp = " + temp + "  maxlen = " + maxLen);
            }

            return maxLen;
        }
    }
}
