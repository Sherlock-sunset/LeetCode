package com.sherlock.normal;

public class J44 {
    public int findNthDigit(int n) {
        if (n <= 9) return n;
        double count = 90, len = 2, sum = 9;
        while (true) {
            sum += count * len;
            if (sum == n) return 9;
            if (sum > n) break;
            count *= 10;
            len++;
        }
        double m = n - sum + count * len;
        int result = (int) Math.pow(10, len - 1);
        m -= 1;
        result += (int) (m / len);
        int p = (int) (m % len);
        char[] s = String.valueOf(result).toCharArray();
        return Integer.parseInt(s[p]+"");

    }
}
