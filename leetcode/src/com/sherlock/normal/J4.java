package com.sherlock.normal;

public class J4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0)
            return false;
        if (matrix[0].length == 0)
            return false;
        int n = matrix.length, m = matrix[0].length,maxn = n ,maxm = m;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < maxm; j++) {
                if (matrix[i][j] == target)
                    return true;
                if (matrix[i][j] > target) {
                    if (j == 0)
                        return false;
                    maxm = j + 1;
                    break;
                }
            }

        }

        return false;
    }
}
