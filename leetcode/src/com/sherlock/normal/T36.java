package com.sherlock.normal;

import java.util.HashMap;

//通过记录行列宫里的元素
public class T36 {
    public boolean isValidSudoku(char[][] board) {
        // init data
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }
        for (int i = 0; i < 9; i++) { //行
            for (int j = 0; j < 9; j++) {//列
                if (board[i][j] != '.') {
                    int n = Integer.parseInt(board[i][j] + "");
                    //判断个数
                    int boxIndex = i / 3 + (j / 3) * 3;
                    if (rows[i].get(n) != null || columns[j].get(n) != null || boxes[boxIndex].get(n) != null) {
                        return false;
                    }
                    rows[i].put(n, 1);
                    columns[j].put(n, 1);
                    boxes[boxIndex].put(n, 1);
                }
            }
        }

        return true;
    }

}
