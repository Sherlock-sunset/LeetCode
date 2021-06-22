package com.sherlock.hard;

import java.util.HashMap;

public class J19 {
    public boolean isMatch(String s, String p) {
        HashMap<String, Boolean> dict = new HashMap<>();
        return matchHelper(dict, s, p);
    }

    private boolean matchHelper(HashMap<String, Boolean> dict, String s, String p) {
        return false;
    }

//    private boolean matchHelper(HashMap<String, Boolean> dict, String s, String p) {
//        if (s.isEmpty()) return p.isEmpty() || p.equals("*");
//        if (p.isEmpty()) return false;
//        Boolean ans = dict.get(s + "," + p);
//        if (ans != null) return ans;
//
//        char a = s.charAt(0);
//        char b = p.charAt(0);
//        if (s.length() == 1) {
//            ans = false;
//            StringBuilder sb = new StringBuilder(p);
//            while (sb.toString().startsWith("*")) {
//                ans = true;
//                sb.deleteCharAt(0);
//            }
//            if (sb.length() > 0) {
//                if (sb.toString().startsWith(".") || sb.toString().startsWith(a + "")) {
//                    ans = true;
//                    sb.deleteCharAt(0);
//                    if (sb.length() > 0) {
//                        while (sb.toString().startsWith("*")) {
//                            ans = true;
//                            sb.deleteCharAt(0);
//                        }
//                        if (sb.length() > 0) return false;
//                    }
//                } else {
//                    ans = false;
//                }
//            }
//            dict.put(s + "," + p, ans);
//            return ans;
//        }
//        ans = false;
//        if (b == '*') {
//            ans = matchHelper(dict, s.substring(1), p);
//            if (ans) {
//                dict.put(s + "," + p, ans);
//                return ans;
//            }
//            ans = matchHelper(dict, s.substring(1), p.substring(1));
//
//        } else if (b == '.') {
//            ans = matchHelper(dict, s.substring(1), p.substring(1));
//        } else {
//            if (a == b) ans = matchHelper(dict, s.substring(1), p.substring(1));
//        }
//
//        dict.put(s + "," + p, ans);
//        return ans;
//    }
}
