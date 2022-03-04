package com.sherlock.offer;

import java.util.HashMap;

public class Day5 {
    /**
     * 剑指 Offer 04. 二维数组中的查找
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int x = 0, y = 0;
        return findNumberIn2DArray(matrix, target, x, y, matrix.length, matrix[0].length);
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target, int x, int y, int n, int m) {
        if (matrix[x][y] == Integer.MIN_VALUE) return false; //访问过就不再访问
        if (matrix[x][y] == target) return true;
        if (matrix[x][y] < target) {
            matrix[x][y] = Integer.MIN_VALUE;
            if (x + 1 < n && y + 1 < m) {
                if (findNumberIn2DArray(matrix, target, x + 1, y + 1, n, m)) return true;
            } else if (x + 1 < n) {
                if (findNumberIn2DArray(matrix, target, x + 1, y, n, m)) return true;
            } else if (y + 1 < m) {
                if (findNumberIn2DArray(matrix, target, x, y + 1, n, m)) return true;
            }
        } else {
            matrix[x][y] = Integer.MIN_VALUE;
            if (x - 1 >= 0) {
                if (findNumberIn2DArray(matrix, target, x - 1, y, n, m)) return true;
            }
            if (y - 1 >= 0) {
                if (findNumberIn2DArray(matrix, target, x, y - 1, n, m)) return true;
            }
        }
        return false;
    }


    /**
     * 剑指 Offer 11. 旋转数组的最小数字
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 给你一个可能存在重复元素值的数组numbers，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。
     * 请返回旋转数组的最小元素。例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为1。
     */
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (numbers[left] > numbers[mid]) {//mid < left,发生旋转
                right = mid;
            } else if (numbers[mid] > numbers[right]) {//mid > right,发生旋转
                left = mid + 1;
            } else {
                right--;
            }
        }

        return numbers[left];
    }


    /**
     * 剑指 Offer 50. 第一个只出现一次的字符
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     */
    public char firstUniqChar(String s) {
        char ans = ' ';
        HashMap<Character, Integer> dic = new HashMap<>();
        for (char c : s.toCharArray()) {
            dic.put(c, dic.getOrDefault(c, 0) + 1);
        }
        for (char c : s.toCharArray()) {
            if (dic.get(c)==1) return c;
        }
        return ans;
    }
}
