package com.sherlock.twice;

public class J13 {
    public int movingCount(int m, int n, int k) {
        boolean[][] graph = new boolean[m][n];
        return trackback(graph, 0, k, 0, 0);
    }

    private int trackback(boolean[][] graph, int current, int k, int x, int y) {
        if (current > k || x >= graph.length || x < 0 || y < 0 || y >= graph[0].length || graph[x][y]) return 0;
        graph[x][y] = true;
        int ans = 1, next = current;
        if (x % 10 == 9) next = current - 8;
        else next = current + 1;
        ans += trackback(graph, next, k, x + 1, y);
        if (y % 10 == 9) next = current - 8;
        else next = current + 1;
        ans += trackback(graph, next, k, x, y + 1);
        if (x % 10 == 0) next = current + 8;
        else next = current - 1;
        ans += trackback(graph, next, k, x - 1, y);
        if (y % 10 == 0) next = current + 8;
        else next = current - 1;
        ans += trackback(graph, next, k, x, y - 1);
        return ans;
    }
}
