package com.sherlock.offer;

public class Day3 {
    /**
     * 剑指 Offer 05. 替换空格
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     */
    public String replaceSpace(String s) {
        StringBuffer ans = new StringBuffer();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                ans.append("%20");
            } else {
                ans.append(c);
            }
        }
        return ans.toString();
    }


    /**
     * 剑指 Offer 58 - II. 左旋转字符串
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
     * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"
     */

    public String reverseLeftWords(String s, int n) {
        StringBuffer ans = new StringBuffer();
        char[] array = s.toCharArray();
        for (int i = n; i < n + array.length; i++) {
            if (n >= array.length) {
                ans.append(array[i - array.length]);
            } else {
                ans.append(array[i]);
            }
        }
        return ans.toString();
    }
}
