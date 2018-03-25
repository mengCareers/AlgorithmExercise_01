/*
The word can be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.
 * Thought Process:
 * 
 */
package DFS;

/**
 *
 * @author xinrong
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (util(board, word, 0, i, j, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean util(char[][] board, String word, int start, int x, int y, boolean[][] visited) {
        if (start == word.length()) {
            return true;
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] || word.charAt(start) != board[x][y]) {
            return false;
        }
        visited[x][y] = true;
        if (util(board, word, start + 1, x + 1, y, visited)
                || util(board, word, start + 1, x, y + 1, visited)
                || util(board, word, start + 1, x - 1, y, visited)
                || util(board, word, start + 1, x, y - 1, visited)) {
            return true;
        }
        visited[x][y] = false;
        return false;
    }

}
