package com.sherlock.normal;

import java.math.BigDecimal;

public class J14_2 {
    public int cuttingRope(int n) {
        if (n <= 3)
            return n - 1;
        int a = n / 3, b = n % 3;
        double r = 1;
        for (int i = 0; i < a - 1; i++) {
            r *= 3;
            r %= 1000000007;
        }

        if (b == 0) return (int) (r * 3 % 1000000007);
        if (b == 1) return (int) (r * 4 % 1000000007);
        return (int) (r * 3 * 2 % 1000000007);
    }

}
