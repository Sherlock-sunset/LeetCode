package com.sherlock.easy;

public class T69 {
    public int mySqrt(int x) {
        for (double i = 0; i < Integer.MAX_VALUE; i++) {
            if (x == i * i)
                return (int) i;
            if (x < i * i)
                return (int) i -1;
        }
        return 0;
    }
}
