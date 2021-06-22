package com.sherlock.twice;

import java.util.HashMap;

public class T76 {
    public String minWindow(String s, String t) {
        if (t.length() <= 1) return s.contains(t) ? t : "";
        String ans = "";
        int n = t.length(), current = 0;
        HashMap<Character, Integer> dict = new HashMap<>();
        for (char c : t.toCharArray()) {
            dict.put(c, dict.getOrDefault(c, 0) + 1);

        }
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        char[] sc = s.toCharArray();
        map.put(sc[left], map.getOrDefault(sc[left], 0) + 1);
        if (dict.getOrDefault(sc[left], 0) > 0) current++;

        while (left < sc.length && right < sc.length) {
            if (current < n) {
                right++;
                if (right >= sc.length) break;
                int num = map.getOrDefault(sc[right], 0) + 1;
                map.put(sc[right], num);
                int target = dict.getOrDefault(sc[right], 0);
                if (target > 0 && num <= target) {//是t中的字符
                    current++;
                    if (current == n) {
                        String buff = s.substring(left, right + 1);
                        if (ans.isEmpty() || buff.length() < ans.length()) {
                            ans = buff;
                        }
                    }

                }
            } else {
                int num = map.getOrDefault(sc[left], 0) - 1;
                map.put(sc[left], num);
                int target = dict.getOrDefault(sc[left], 0);

                if (num < target) {
                    current--;
                } else {
                    String buff = s.substring(left + 1, right + 1);
                    if (ans.isEmpty() || buff.length() < ans.length()) {
                        ans = buff;
                    }
                }
                left++;
                if (left >= sc.length) break;

            }


        }

        return ans;
    }
}
