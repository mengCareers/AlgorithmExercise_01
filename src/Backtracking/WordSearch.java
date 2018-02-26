/* 79. Word Search
input : board
        word
output: true if exist adj seq to construc word
 * Thought Process:
 * 
 */
package Backtracking;

/**
 *
 * @author xinrong
 */
public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        String word = "ABCCED";
        boolean ans = new WordSearch().exist(board, word);
        System.out.println(ans);
    }
    
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (util(i, j, 0, board, word, visited)) {
                    return true;
                }

            }

        }
        return false;
    }

    private boolean util(int x, int y, int wi, char[][] board, String word, boolean[][] visited) {
        if (wi == word.length()) {
            return true;
        }

        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] || board[x][y] != word.charAt(wi)) {
            return false;
        }

        visited[x][y] = true;
        if (util(x, y + 1, wi + 1, board, word, visited) || util(x + 1, y, wi + 1, board, word, visited) || util(x, y - 1, wi + 1, board, word, visited) || util(x - 1, y, wi + 1, board, word, visited)) {
            return true;
        }
        visited[x][y] = false;

        return false;
    }
}
