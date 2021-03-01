package com.sherlock.normal;

import java.util.*;

public class T131 {
    public List<List<String>> partition(String s) {
        char[] chars = s.toCharArray();
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        partition(result, list, chars, 0);

        return result;
    }

    public void partition(List<List<String>> result, List<String> list, char[] chars, int index) {
        List<String> member = new ArrayList<>();
        if (index == chars.length - 1) {
            member.addAll(list);
            member.add(String.valueOf(chars[index]));
            result.add(member);
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = index; i < chars.length; i++) {
            sb.append(chars[i]);
            if (isValid(sb.toString())) {
                member.clear();
                member.addAll(list);
                member.add(sb.toString());
                if (i >= chars.length - 1) {
                    result.add(member);
                    return;
                } else partition(result, member, chars, i + 1);
            }
        }
    }

    private boolean isValid(String str) {
        char[] chars = str.toCharArray();
        if (chars.length == 1) return true;
        int l = 0, r = chars.length - 1;
        while (l < r) {
            if (chars[l] != chars[r]) return false;
            if (r - l <= 2) return true;
            l++;
            r--;
        }
        return true;
    }

}
