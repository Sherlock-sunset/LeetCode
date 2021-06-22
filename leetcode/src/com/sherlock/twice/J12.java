package com.sherlock.twice;

public class J12 {
    public boolean exist(char[][] board, String word) {
        if (board.length < 1 || board[0].length < 1) return false;
        char[] searchTarget = word.toCharArray();
        boolean[][] isSearched = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (trackback(board, searchTarget, 0, i, j, isSearched)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean trackback(char[][] board, char[] word, int current, int x, int y, boolean[][] isSearched) {
        if (current >= word.length) return true;
        if (x >= board.length || y >= board[0].length || x < 0 | y < 0 || isSearched[x][y]) return false;
        if (board[x][y] == word[current]) {
            isSearched[x][y] = true;
            if (trackback(board, word, current + 1, x + 1, y, isSearched)) {
                return true;
            }
            if (trackback(board, word, current + 1, x, y + 1, isSearched)) {
                return true;
            }
            if (trackback(board, word, current + 1, x - 1, y, isSearched)) {
                return true;
            }
            if (trackback(board, word, current + 1, x, y - 1, isSearched)) {
                return true;
            }
        }

        isSearched[x][y] = false;
        return false;
    }

}
