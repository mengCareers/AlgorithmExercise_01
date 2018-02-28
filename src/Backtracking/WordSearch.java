/* 79. Word Search
input : board
        word
output: true if exist adj seq to construc word
 * Thought Process:
 * break when wi == word.length
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
    
    boolean[][] visited;
    
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (util(i, j, board, word, 0))
                    return true;
            }
        }
        return false;
    }
    
    boolean util(int x, int y, char[][] board, String word, int wi) {
        if (wi == word.length()) 
            return true;
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] || wi > word.length() || word.charAt(wi) != board[x][y])
            return false;
        visited[x][y] = true;
        if (util(x + 1, y, board, word, wi + 1) 
            || util(x, y + 1, board, word, wi + 1) 
            || util(x - 1, y, board, word, wi + 1) 
            || util(x, y - 1, board, word, wi + 1))
            return true;
        visited[x][y] = false;
        return false;
    }
}
