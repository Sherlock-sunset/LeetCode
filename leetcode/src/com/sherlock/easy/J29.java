package com.sherlock.easy;

public class J29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix==null || matrix.length==0 ||matrix[0].length ==0)
            return new int[0];
        int[] results = new int[matrix.length * matrix[0].length];

        for (int i = 0, m = 0, n = 0, t = 0; i < results.length; i++) {
            results[i] = matrix[m][n];
            if (m == t && n + 1 < matrix[0].length - t)
                n++;
            else if (n == matrix[0].length - 1 - t && m + 1 < matrix.length - t)
                m++;
            else if (m == matrix.length - 1 - t && n - 1 >= t)
                n--;
            else if (n == t && m ==t+1){
                n++;
                t++;
            }else m--;
        }
        return results;
    }
}
