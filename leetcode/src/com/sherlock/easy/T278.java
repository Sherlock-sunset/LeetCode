package com.sherlock.easy;

public class T278 {
    boolean isBadVersion(int version) {
        return true;
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n, mid = 0, ans = Integer.MAX_VALUE;
        while (left <= right) {
            //mid = (left + right)  这种写法超出Int计算范围
            mid = left+(right-left)/2;
            if (isBadVersion(mid)) {
                right = mid - 1;
                if (mid < ans) ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
