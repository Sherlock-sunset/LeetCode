package com.sherlock.easy;

public class T191 {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += n & 1;
            n = n >>> 1;
        }
        return count;
    }
//    public int hammingWeight(int n) {
//        String b = Integer.toBinaryString(n);
//        char[] c = b.toCharArray();
//        int count = 0;
//        for (int i = 0; i < c.length; i++) {
//            count += 1 & (int) c[i];
//        }
//        return count;
//    }
}
