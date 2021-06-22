package com.sherlock.hard;

public class T52 {
    public int totalNQueens(int n) {
        if (n < 2) return n;
        boolean[][] isExist = new boolean[n][n];
        return trackback(n, 1, isExist);
    }

    private int trackback(int n, int current, boolean[][] isExist) {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (can(isExist, current - 1, i)) {
                isExist[current - 1][i] = true;
                if (current == n) {
                    ans++;
                } else {
                    ans += trackback(n, current + 1, isExist);
                }
                isExist[current - 1][i] = false;

            }
        }

        return ans;
    }

    private boolean can(boolean[][] isExist, int x, int y) {
        for (int i = 0; i < x; i++) {
            if (isExist[i][y]) return false;
        }
        int x2 = x - 1, y2 = y - 1;
        while (x2 >= 0 && y2 >= 0) {
            if (isExist[x2--][y2--]) return false;
        }
        x2 = x - 1;
        y2 = y + 1;
        while (x2 >= 0 && y2 < isExist.length) {
            if (isExist[x2--][y2++]) return false;
        }
        return true;

    }
}
