package com.sherlock.normal;

import java.util.HashMap;

public class T79 {
    public boolean exist(char[][] board, String word) {
        if (word.isEmpty())
            return true;
        if (board.length <= 0 || board[0].length <= 0)
            return false;
        char[] s = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == s[0]) {
                    if (s.length == 1)
                        return true;
                    HashMap<String, Boolean> map = new HashMap<>();
                    map.put(i + "," + j, true);
                    if (backtrack(board, s, 1, i, j, map)) return true;
                }
            }

        }
        return false;
    }

    public boolean backtrack(char[][] board, char[] s, int startC, int oi, int oj, HashMap<String, Boolean> map) {
        if (startC >= s.length)
            return true;
        if (oj - 1 >= 0 && !map.getOrDefault(oi + "," + (oj - 1), false) && board[oi][oj - 1] == s[startC]) {
            HashMap<String, Boolean> visited = new HashMap<>(map);
            visited.put(oi + "," + (oj - 1), true);
            if (backtrack(board, s, startC + 1, oi, oj - 1, visited)) return true;
        }
        if (oj + 1 < board[0].length && !map.getOrDefault(oi + "," + (oj + 1), false) && board[oi][oj + 1] == s[startC]) {
            HashMap<String, Boolean> visited = new HashMap<>(map);
            visited.put(oi + "," + (oj + 1), true);
            if (backtrack(board, s, startC + 1, oi, oj + 1, visited)) return true;
        }
        if (oi + 1 < board.length && !map.getOrDefault((oi + 1) + "," + oj, false) && board[oi + 1][oj] == s[startC]) {
            HashMap<String, Boolean> visited = new HashMap<>(map);
            visited.put((oi + 1) + "," + oj, true);
            if (backtrack(board, s, startC + 1, oi + 1, oj, visited)) return true;
        }
        if (oi - 1 >= 0 && !map.getOrDefault((oi - 1) + "," + oj, false) && board[oi - 1][oj] == s[startC]) {
            HashMap<String, Boolean> visited = new HashMap<>(map);
            visited.put((oi - 1) + "," + oj, true);
            if (backtrack(board, s, startC + 1, oi - 1, oj, visited)) return true;
        }
        return false;
    }
}
