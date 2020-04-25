package com.sherlock.easy;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * <p>
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 * <p>
 */
public class T14 {
    public static void main(String[] args) {
        Solution so = new Solution();
        System.out.println(so.longestCommonPrefix("flower", "flow", "flight"));
        System.out.println(so.longestCommonPrefix("dog", "racecar", "car"));
        System.out.println(so.longestCommonPrefix("aa", "a", "a"));
    }

    public static class Solution {
        public String longestCommonPrefix(String... strs) {
            String result = "";
            if (strs == null || strs.length == 0)
                return result;
            char[] resultArry = strs[0].toCharArray();
            int resultLen = resultArry.length;
            for (int i = 1; i < strs.length && resultLen > 0; i++) {
                char[] current = strs[i].toCharArray();

                for (int j = 0; j < resultLen && j < current.length; j++) {
                    if (current[j] != resultArry[j]) {
                        resultLen = j;
                        break;
                    }
                }
                resultLen = resultLen >= current.length? current.length : resultLen;
            }
            for (int i = 0; i < resultLen; i++) {
                result += resultArry[i];
            }
            return result;
        }
    }
}
