package com.sherlock.normal;

import java.util.HashMap;

public class J13 {
    public int movingCount(int m, int n, int k) {
        if (k==0)
            return 1;
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        backtrack(m,n,0,0,k,visited);
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum+= visited[i][j]?1:0;
            }
        }
        return sum;
    }

    public boolean isExist(int x, int y, int k) {
        int sum = 0;
        while (x / 10 > 0) {
            sum += x % 10;
            x /= 10;
        }
        while (y / 10 > 0) {
            sum += y % 10;
            y /= 10;
        }
        return x + y + sum <= k;
    }
    public void backtrack(int m,int n, int x,int y, int k,boolean[][] visited) {
        if (x-1>=0 && !visited[x-1][y] && isExist(x-1,y,k)){
            visited[x-1][y] = true;
            backtrack(m,n,x-1,y,k,visited);
        }
        if (x+1<m && !visited[x+1][y] && isExist(x+1,y,k)){
            visited[x+1][y] = true;
            backtrack(m,n,x+1,y,k,visited);
        }
        if (y-1>=0 && !visited[x][y-1] && isExist(x,y-1,k)){
            visited[x][y-1] = true;
            backtrack(m,n,x,y-1,k,visited);
        }
        if (y+1<n && !visited[x][y+1] && isExist(x,y+1,k)){
            visited[x][y+1] = true;
            backtrack(m,n,x,y+1,k,visited);
        }
    }


}
