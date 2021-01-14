package com.sherlock.easy;

public class J17 {
    public int[] printNumbers(int n) {
        int[] res = new int[(int) (Math.pow(10.0, n) - 1)];
        for (int i = 1; i < Math.pow(10.0, n); i++) {
            res[i-1] = i;
        }
        return res;
    }
}
