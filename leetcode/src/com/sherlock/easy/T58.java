package com.sherlock.easy;

public class T58 {
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int wordlength = 0 ;
        int start = -1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' '){
                wordlength = i - start;
            }else {
                start = i;
            }
        }
        return wordlength;
    }
}
