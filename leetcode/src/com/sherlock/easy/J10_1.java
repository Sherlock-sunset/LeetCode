package com.sherlock.easy;

import java.util.ArrayList;
import java.util.List;

public class J10_1 {
    public int fib(int n) {
        if (n <= 1)
            return n;
        double[] num = {1.0, 1.0};
        for (int i = 3; i <= n; i++) {
                double b = (num[1] + num[0]) % 1000000007;
                num[0] = num[1];
                num[1] = b;
        }
        return (int) num[1];
    }
}
