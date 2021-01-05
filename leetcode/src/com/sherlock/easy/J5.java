package com.sherlock.easy;

public class J5 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        char [] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' '){
                sb.append(chars[i]);
            }else {
                sb.append("%20");
            }
        }

        return sb.toString();
    }
}
