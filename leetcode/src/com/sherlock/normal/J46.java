package com.sherlock.normal;

public class J46 {
    public int translateNum(int num) {
        char[] s = String.valueOf(num).toCharArray();
        if (s.length < 2) return 1;
        return trackback(s, 0, 1) + trackback(s, 0, 2);

    }

    public int trackback(char[] s, int start, int len) {
        if (start + len - 1 >= s.length) return 0;
        Integer num = null;
        if (len == 1)
            num = Integer.parseInt(s[start] + "");
        else {
            num = Integer.parseInt(s[start] + "" + s[start + 1]);
            if (num<10) return 0;
        }
        if (num < 0 || num > 25) return 0;
        if (start + len == s.length) return 1;
        return trackback(s, start + len, 1) + trackback(s, start + len, 2);

    }
}
