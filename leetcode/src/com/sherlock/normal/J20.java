package com.sherlock.normal;

public class J20 {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.isEmpty())
            return false;
        char[] chars = s.toCharArray();
        int numF = 0, numE = 0, numP = 0;
        for (int i = 0; i < s.length(); i++) {
            if (('0' > chars[i] || chars[i] > '9') && chars[i] != 'e' && chars[i] != 'E' && chars[i] != '.' && chars[i] != '+' && chars[i] != '-')
                return false;
            if (chars[i] == '.')
                numF++;
            if (chars[i] == 'e' || chars[i] == 'E')
                numE++;

            if (chars[i] == '+' || chars[i] == '-')
                numP++;
        }
        if ((numE + numF > 1) || (numE == 0 && numP > 1) || (numE > 0 && numP > 2))
            return false;
        if (numE + numF == 0) return isInteger(chars);
        if (numF > 0) return isFloat(chars, numP);
        else return isExponet(chars, numP);
    }

    private boolean isExponet(char[] s, int numP) {
        if (s.length < 3)
            return false;
        for (int i = 0; i < s.length; i++) {
            if (i == 0) {
                if (numP > 0 && (s[i] == '+' || s[i] == '-')) {
                    numP--;
                    if (s[i+1] == 'e' || s[i+1] == 'E')
                        return false;
                }
                if ((s[i] == 'e' || s[i] == 'E'))
                    return false;

            } else {

                if ((s[i] == 'e' || s[i] == 'E') && numP > 0 && (s[i + 1] != '+' && s[i + 1] != '-')) {
                    return false;
                }
                if ((s[i] == 'e' || s[i] == 'E') && i == s.length - 1) {
                    return false;
                }
                if ((s[i] == '+' || s[i] == '-') && (i == s.length - 1 || (s[i - 1] != 'e' && s[i - 1] != 'E')))
                    return false;
                if ((s[i] == '+' || s[i] == '-') && (s[i + 1] == 'e' || s[i + 1] == 'E'))
                    return false;

            }
        }
        return true;
    }

    private boolean isFloat(char[] s, int nump) {
        if (s.length < 2 + nump)
            return false;
        for (int i = 0; i < s.length; i++) {
            if ((s[i] == '+' || s[i] == '-') && i != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isInteger(char[] s) {
        for (int i = 0; i < s.length; i++) {
            if ((s[i] == '+' || s[i] == '-') && i != 0) {
                return false;
            }
        }
        return true;
    }
}
