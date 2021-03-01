package com.sherlock.normal;

public class J64 {
    public int sumNums(int n) {
        int r = n + pow2(n, n);
        r = r >> 1;
        return r;
    }

    private int pow2(int n, int m) {
        if (m == 1) return n;
        return n + pow2(n, --m);
    }
}
