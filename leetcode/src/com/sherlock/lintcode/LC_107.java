package com.sherlock.lintcode;

import java.util.Set;

public class LC_107 {
    /**
     * @param s: A string
     * @param wordSet: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> wordSet) {
        // write your code here
        if(s.length()<1) return  true;
        boolean[] dp = new boolean[s.length()];
        dp[0] = wordSet.contains(s.substring(0,1));

        for (int i = 1; i < s.length(); i++) {
            boolean isWord = false;
            for (int j = i; j >=0 ; j--) { // (0,i);
                if (j<1 || dp[j-1]) {
                    String word = s.substring(j, i+1);
                    if (wordSet.contains(word)) {
                        isWord = true;
                        break;
                    }
                }
            }
            dp[i] = isWord;
        }



        return dp[s.length()-1];
    }
}
