package com.sherlock.hard;

import java.util.HashMap;

public class T76 {
    public String minWindow(String s, String t) {
        String ans = "";
        if (t.isEmpty() || t.length() > s.length()) return ans;

        char[] chars = s.toCharArray();
        char[] target = t.toCharArray();
        HashMap<Character, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            targetMap.put(target[i], targetMap.getOrDefault(target[i], 0) + 1);
        }

        for (int len = target.length; len <= chars.length; len++) {
            HashMap<Character, Integer> current = new HashMap<>();
            int total = 0;

            for (int i = 0,start =0; i < chars.length; i++) {

                if (i >= len) {
                    char c = chars[start];
                    current.put(c, current.getOrDefault(c, 0) - 1);//出
                    if (targetMap.getOrDefault(c, 0) > current.getOrDefault(c, 0)) total--;
                    start++;
                }

                int num = current.getOrDefault(chars[i], 0) + 1;
                current.put(chars[i], num);
                if (num <= targetMap.getOrDefault(chars[i], 0)) {
                    total++;
                }

                if (total == target.length) {
                    return s.substring(start, i + 1);
                }
            }
        }

        return ans;
    }
}
