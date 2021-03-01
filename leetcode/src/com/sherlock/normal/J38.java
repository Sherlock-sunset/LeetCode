package com.sherlock.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class J38 {
    public String[] permutation(String s) {
        if (s.isEmpty()) return new String[0];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        List<String> list = new ArrayList<>();
        trackBack(chars, list, new boolean[chars.length], 0, new StringBuilder());
        String[] result = new String[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public void trackBack(char[] chars, List<String> list, boolean[] flags, int c, StringBuilder curs) {
        c++;
        Character lastc = null;
        for (int i = 0; i < chars.length; i++) {
            if (!flags[i] && (lastc == null || chars[i] != lastc)) {
                StringBuilder sb = new StringBuilder(curs);
                sb.append(chars[i]);
                if (c == chars.length) {
                    list.add(sb.toString());
//                    sb.deleteCharAt(c - 1);
                } else {
                    flags[i] = true;
                    trackBack(chars, list, flags, c, sb);
                    flags[i] = false;
                }
                lastc = chars[i];
            }
        }
//        if (c < chars.length)
//            sb.deleteCharAt(c - 1);
    }
}
