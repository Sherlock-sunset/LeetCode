package com.sherlock.normal;

import java.util.ArrayList;
import java.util.List;

public class T54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int v = 0, sum = m * n, x = 0, y = 0;
        List<Integer> ans = new ArrayList<>();
        boolean flag = false;
        while (v < sum) {
            visited[x][y] = true;
            v++;
            ans.add(matrix[x][y]);
            if (flag) {
                if (x - 1 >= 0 && !visited[x - 1][y]) {
                    x--;
                    continue;
                }
            }
            if (y + 1 < n && !visited[x][y + 1]) { //右
                flag = false;
                y++;
            } else if (x + 1 < m && !visited[x + 1][y]) {//下
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
