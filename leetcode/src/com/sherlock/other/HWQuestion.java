package com.sherlock.other;

import java.util.Stack;

/**
 * 类描述：补全字符串，以最少的字符补全成回文
 * 创建人：Sherlock
 * 创建时间：2020-08-08
 * 修改备注：
 */
public class HWQuestion {

    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.longestPalindrome("hello"));
        System.out.println(so.longestPalindrome("bbbbb"));
        System.out.println(so.longestPalindrome("bbbbbc"));
        System.out.println(so.longestPalindrome("bbbbbbc"));
        System.out.println(so.longestPalindrome("pwwkew"));
        System.out.println(so.longestPalindrome("pwwkewasdasdascknjkasnkjsdahss"));
    }

    public static class Solution {
        public String longestPalindrome(String s) {
            char[] charsStr = s.toCharArray();
            int len = charsStr.length;
            int pl = 0, pr = len - 1;
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < len; i++) {
                if (pl == pr)
                    break;
                if (charsStr[pl] == charsStr[pr]) {
                    boolean flag = true;
                    for (int j = 0; j < len / 2; j++) {

                        if (pl + 1 < pr && charsStr[pl + j + 1] != charsStr[pr - 1 - j]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag)
                        break;

                }
                stack.push(charsStr[i]);
                pl++;
            }
            StringBuilder sb = new StringBuilder(s);

            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            return sb.toString();
        }
    }
}
