package com.sherlock.lintcode;

import java.util.*;

public class LC_582 {
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */

    //    public List<String> wordBreak(String s, Set<String> wordDict) {
//        // write your code here
//        if (s.length() < 1) return new ArrayList<>();
//        List<String>[] dp = new List[s.length()];
//        for (int i = 0; i < s.length(); i++) {
//            List<String> ans = new ArrayList<>();
//
//             findContence(ans, i, s, wordDict, dp);
//            dp[i] = ans;
//        }
//
//        return dp[s.length() - 1];
//    }
//
//    private void findContence(List<String> ans, int endPoistion, String s, Set<String> wordDict, List<String>[] dp) {
//
//        for (int j = endPoistion; j >= 0; j--) { // (0,i);
//            if (j < 1 || !dp[j - 1].isEmpty()) {
//                String word = s.substring(j, endPoistion + 1);
//                if (wordDict.contains(word)) {
//                    if (j < 1) ans.add(word);
//                    else {
//                        for (String con : dp[j - 1]) {
//                            ans.add(con + " " + word);
//                        }
//                    }
//
//                }
//            }
//        }
//    }
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Map<String, ArrayList<String>> memo = new HashMap<>();
        return wordBreakHelper(s, dict, memo);
    }

    public ArrayList<String> wordBreakHelper(String s,
                                             Set<String> dict,
                                             Map<String, ArrayList<String>> memo) {
        if (memo.containsKey(s)) return memo.get(s);
        ArrayList<String> ans = new ArrayList<>();
        for (int len = 1; len <= s.length(); len++) {
            String word = s.substring(0, len);
            if (dict.contains(word)) {
                if (word.length() == s.length()) ans.add(word);
                else {
                    ArrayList<String> sentences = wordBreakHelper(s.substring(len), dict, memo);
                    for (String sentence : sentences) {
                        ans.add(word + " " + sentence);
                    }
                }

            }

        }
        memo.put(s,ans);

        return ans;
    }

}
