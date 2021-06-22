package com.sherlock.normal;

import java.util.ArrayList;
import java.util.List;

public class T59 {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        int v = 1, sum = n * n, x = 0, y = 0;
        boolean flag = false;
        while (v <=  sum) {
            visited[x][y] = true;
            ans[x][y] = v;
            v++;
            if (flag) {
                if (x - 1 >= 0 && !visited[x - 1][y]) {
                    x--;
                    continue;
                }
            }
            if (y + 1 < n && !visited[x][y + 1]) { //右
                flag = false;
                y++;
            } else if (x + 1 < n && !visited[x + 1][y]) {//下
                flag = false;

                x++;
            } else if (y - 1 >= 0 && !visited[x][y - 1]) {  //左
                flag = false;
                y--;
            } else {  //上
                flag = true;
                x--;
            }
        }
        return ans;
    }

}
