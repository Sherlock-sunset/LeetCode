package com.sherlock.hard;

import java.util.ArrayList;
import java.util.List;

public class T51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        if (n < 1) return ans;
        boolean[][] isExist = new boolean[n][n];
        trackback(n, 1, isExist, ans);
        return ans;
    }

    private void trackback(int n, int current, boolean[][] isExist, List<List<String>> ans) {
        for (int i = 0; i < n; i++) {
            if (can(isExist, current - 1, i)) {
                isExist[current - 1][i] = true;
                if (current == n) {
                    record(isExist, ans);
                } else {
                    trackback(n, current + 1, isExist, ans);
                }
                isExist[current - 1][i] = false;

            }
        }

    }

    private void record(boolean[][] isExist, List<List<String>> ans) {
        List<String> r = new ArrayList<>();
        for (int i = 0; i < isExist.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < isExist.length; j++) {
                sb.append(isExist[i][j] ? "Q" : ".");
            }
            r.add(sb.toString());
        }
        ans.add(r);
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
