package com.sherlock.lintcode;

import java.util.*;

public class LC_683 {
    /**
     * @param s: A string
     * @param dict: A set of word
     * @return: the number of possible sentences.
     */
    public int wordBreak3(String s, Set<String> dict) {
        // Write your code here
        HashMap<String,Integer> memo = new HashMap<>();
        Iterator<String> it = dict.iterator();
        Set<String> newDict = new HashSet<>();
        while (it.hasNext()){
            String word = it.next().toLowerCase();
            newDict.add(word);
        }
        return wordBreakHelper(s,newDict,memo);
    }

    private int wordBreakHelper(String s, Set<String> dict, HashMap<String, Integer> memo) {
        if (memo.containsKey(s)) return memo.get(s);
        int ans = 0;
        for (int len = 1; len < s.length(); len++) {
            String word = s.substring(0,len).toLowerCase();
            if (dict.contains(word)){
                ans += wordBreakHelper(s.substring(len).toLowerCase(),dict,memo);
            }
        }
        if (dict.contains(s)) ans++;
        memo.put(s,ans);
        return ans;
    }
}
