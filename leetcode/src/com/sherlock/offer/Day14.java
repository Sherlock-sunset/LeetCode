package com.sherlock.offer;

import java.util.HashMap;

public class Day14 {
    /**
     * 剑指 Offer 12. 矩阵中的路径
     * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
     * 同一个单元格内的字母不允许被重复使用。
     */
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        char[] wordChars = word.toCharArray();
        boolean[][] dic = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (wordChars[0] == board[i][j]) {
                    dic[i][j] = true;
                    if (trackback(board, wordChars, dic, 1, i, j, n, m)) {
                        return true;
                    }
                    dic[i][j] = false;
                }
            }
        }

        return false;
    }

    private boolean trackback(char[][] board, char[] wordChars, boolean[][] dic, int p, int x, int y, int n, int m) {
        if (p == wordChars.length) return true;

        if (x - 1 >= 0 && !dic[x - 1][y] && board[x - 1][y] == wordChars[p]) {
            dic[x - 1][y] = true;
            if (trackback(board, wordChars, dic, p + 1, x - 1, y, n, m)) return true;
            dic[x - 1][y] = false;
        }
        if (y - 1 >= 0 && !dic[x][y - 1] && board[x][y - 1] == wordChars[p]) {
            dic[x][y - 1] = true;
            if (trackback(board, wordChars, dic, p + 1, x, y - 1, n, m)) return true;
            dic[x][y - 1] = false;
        }
        if (x + 1 < n && !dic[x + 1][y] && board[x + 1][y] == wordChars[p]) {
            dic[x + 1][y] = true;
            if (trackback(board, wordChars, dic, p + 1, x + 1, y, n, m)) return true;
            dic[x + 1][y] = false;
        }
        if (y + 1 < m && !dic[x][y + 1] && board[x][y + 1] == wordChars[p]) {
            dic[x][y + 1] = true;
            if (trackback(board, wordChars, dic, p + 1, x, y + 1, n, m)) return true;
            dic[x][y + 1] = false;
        }

        return false;
    }

    /**
     * 剑指 Offer 13. 机器人的运动范围
     * <p>
     * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
     * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
     * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
     * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
     */
    public int movingCount(int m, int n, int k) {
        boolean[][] dic = new boolean[m][n];
        dic[0][0] = true;
        HashMap<Boolean, Integer> ans = new HashMap<>();
        ans.put(true, 1);
        movingTrack(m, n, dic, 0, 0, k, ans);
        return ans.get(true);
    }

    private void movingTrack(int m, int n, boolean[][] dic, int x, int y, int k, HashMap<Boolean, Integer> ans) {
        if (x - 1 >= 0 && !dic[x - 1][y] && sumK(x - 1, y, k)) {
            dic[x - 1][y] = true;
            ans.put(true, ans.get(true) + 1);
            movingTrack(m, n, dic, x - 1, y, k, ans);

        }
        if (y - 1 >= 0 && !dic[x][y - 1] && sumK(x, y - 1, k)) {
            dic[x][y - 1] = true;
            ans.put(true, ans.get(true) + 1);
            movingTrack(m, n, dic, x, y - 1, k, ans);
        }
        if (x + 1 < m && !dic[x + 1][y] && sumK(x + 1, y, k)) {
            dic[x + 1][y] = true;
            ans.put(true, ans.get(true) + 1);
            movingTrack(m, n, dic, x + 1, y, k, ans);
        }
        if (y + 1 < n && !dic[x][y + 1] && sumK(x, y + 1, k)) {
            dic[x][y + 1] = true;
            ans.put(true, ans.get(true) + 1);
            movingTrack(m, n, dic, x, y + 1, k, ans);
        }

    }

    private boolean sumK(int x, int y, int k) {
        int sum = 0;
        String vx = String.valueOf(x);
        String vy = String.valueOf(y);
        for (char c : vx.toCharArray()) {
            sum += c - '0';
        }
        for (char c : vy.toCharArray()) {
            sum += c - '0';
        }
        return sum <= k;
    }
}
