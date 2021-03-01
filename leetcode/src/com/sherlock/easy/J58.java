package com.sherlock.easy;

public class J58 {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[arr.length - i - 1].isEmpty()) continue;
            if (i > 0) sb.append(" ");
            sb.append(arr[arr.length - i - 1]);
        }
        return sb.toString();
    }

    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
