package com.sherlock.easy;

public class T557 {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i>0){
                ans.append(" ");
            }
            ans.append(reverseString(words[i].toCharArray()));
        }
        return ans.toString();
    }

    public String reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[right];
            s[right--] = s[left];
            s[left++] = temp;
        }
        return new String(s);
    }
}
