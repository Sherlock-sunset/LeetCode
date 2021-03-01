package com.sherlock.normal;

public class J67 {
    public int strToInt(String str) {
        String target = getFirstStr(str);
        if (target.isEmpty()) return 0;
        char[] tartgeChars = target.toCharArray();
        if (!isValiad(tartgeChars)) return 0;
        boolean p = tartgeChars[0] != '-';
        double r = 0.0;
        for (int i = 0; i < tartgeChars.length; i++) {
            if (tartgeChars[i] > '9' || tartgeChars[i] < '0') {
                if (i == 0)
                    continue;
                else
                    break;
            }
            r *= 10;
            r += tartgeChars[i] - '0';
            if (p && r >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (!p && -r <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }


        return (int) (p ? r : -r);
    }

    private boolean isValiad(char[] tartgeChars) {
        for (int i = 0; i < tartgeChars.length; i++) {
            if (i == 0) {
                if (tartgeChars[i] <= '9' && tartgeChars[i] >= '0') return true;
                else if (tartgeChars[i] != '-' && tartgeChars[i] != '+')
                    return false;
            } else {
                if (tartgeChars[i] <= '9' || tartgeChars[i] >= '0') return true;
            }
        }

        return false;
    }

    private String getFirstStr(String str) {
        String[] strs = str.split(" ");
        String target = "";
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].isEmpty()) continue;
            else {
                target = strs[i];
                break;
            }
        }
        return target;
    }
}
