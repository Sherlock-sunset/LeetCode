package com.sherlock.hard;

public class T10 {
    public boolean isMatch(String s, String p) {
        if (s == null || s.isEmpty())
            return s == null || s.isEmpty();
        char[] ps = p.toCharArray();
        for (int i = 0; i < ps.length; i++) {
            if (completeMatch(s, ps, i))
                return true;
        }

        return false;
    }

    public boolean completeMatch(String s, char[] ps, int n) {
        if (s == null || s.isEmpty())
            return s == null || s.isEmpty();
        char[] ss = s.toCharArray();
        int pl = 0;
        for (int i = n; i < ps.length && pl < ss.length; i++) {
            if (ps[i] == '.') {
                pl++;
            } else if (ps[i] == '*') {
                if (i == ps.length - 1) {
                    return true;
                }
                if (i < ps.length - 1 && ps[i + 1] != '*') {
                    //先判断长度
                    if (pl >= ss.length)
                        return false;
                    if (ps[i++] == '.') {
                        pl++;
                    } else {
                        for (; pl < ss.length && ss[pl] != ps[i]; pl++) {

                        }
                        if (pl >= ss.length || ss[pl] != ps[i])
                            return false;
                    }

                }
            } else if (pl >= ss.length || ss[pl++] != ps[i]) {
                return false;
            }
        }
        if (pl >= ss.length)
            return true;
        return ps[ps.length - 1] == '*';
    }
}
