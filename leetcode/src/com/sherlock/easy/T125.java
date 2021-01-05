package com.sherlock.easy;

public class T125 {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (!isEnglishAndNumber(chars[left])) {
                left++;
            } else if (!isEnglishAndNumber(chars[right])) {
                right--;
            } else if (chars[left] != chars[right]) {
                int dis = 'a' - 'A';

                if ((chars[left] + dis != chars[right]) && (chars[left] - dis != chars[right]))
                    return false;
                else if ('0' <= chars[left] && chars[left] <= '9')
                    return false;
                else if ('0' <= chars[right] && chars[right] <= '9')
                    return false;
                else {
                    left++;
                    right--;
                }
            }else {
                left++;
                right--;
            }

        }
        return true;
    }

    public boolean isEnglishAndNumber(char a) {
        return ('a' <= a && a <= 'z') || ('A' <= a && a <= 'Z') || ('0' <= a && a <= '9');
    }
}
