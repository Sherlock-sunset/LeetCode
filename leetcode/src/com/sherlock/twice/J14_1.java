package com.sherlock.twice;

public class J14_1 {
    public int cuttingRope(int n) {
        if (n < 4) return n - 1;
        if (n == 4) return 4;
        double ans = 1;
        while (true) {
            ans = ans * 3 % 1000000007;
            n -= 3;
            if (n <= 4) return (int) (ans * n % 1000000007);
        }
    }
}
