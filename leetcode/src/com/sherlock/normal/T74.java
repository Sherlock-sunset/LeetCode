package com.sherlock.normal;

import java.util.Arrays;

public class T74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;
        int row = -1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == target) return true;
            if (matrix[i][0] > target) break;
            row = i;
        }
        if (row < 0 || matrix[row][n - 1] < target) return false;
        //二分查找
        int l = 0, r = n - 1;
//        Arrays.binarySearch()
        while (l <= r) {
            int mid = (l + r) / 2;
            if (matrix[row][mid] == target) return true;
            else if (matrix[row][mid] > target) r = mid - 1;
            else l = mid + 1;
        }
        return false;
    }
}
