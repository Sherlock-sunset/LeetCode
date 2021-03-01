package com.sherlock.normal;

public class J66 {
    public int[] constructArr(int[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = 1;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) continue;
            for (int j = 0; j < b.length; j++) {
                if (j == i) continue;
                else b[j] *= a[i];
            }
        }
        return b;
    }
}
