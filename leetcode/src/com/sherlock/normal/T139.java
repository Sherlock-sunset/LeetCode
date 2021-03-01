package com.sherlock.normal;

import java.util.HashMap;
import java.util.List;

public class T139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        char[] chars = s.toCharArray();
        HashMap<Character, Boolean> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            boolean flag = false;
            if (map.getOrDefault(chars[i], false)) continue;
            for (String word : wordDict) {
                if (word.contains(String.valueOf(chars[i]))) {
                    map.put(chars[i], true);
                    flag = true;
                    count++;
                    break;
                }
            }
            if (!flag) return false;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                if (s.length() == word.length() || (count == 1 && s.length() % word.length() == 0)) return true;
                String remain = s.substring(word.length());
                if (wordBreak(remain, wordDict)) return true;
            }
        }
        return false;
    }
}
