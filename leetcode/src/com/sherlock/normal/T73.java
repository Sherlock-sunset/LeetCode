package com.sherlock.normal;

public class T73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean flagC = false,flagR = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                flagC = true;
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                flagR = true;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        if (flagC)
            for (int i = 0; i < m; i++)
                matrix[i][0] = 0;
        if (flagR)
            for (int i = 0; i < n; i++)
                matrix[0][i] = 0;


    }
}
