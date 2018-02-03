/*
 *  LC:
 *  Hint:
 *  Thought Process: if . , try 1 to 9 for each cell
 *  Get: 

 *  usage of backtracking in boolean func & how to go back;
    board[i][j] = c; if (solve(board)) return ture; else board[i][j] = '.'
 * (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
         3 * (row / 3)保证row = 0,1,2时在第0行九宫格左上角，3,4,5时在第1行九宫格左上角。。
         3 * (col / 3)保证col = 0,1,2时在第0列九宫格左上角，3,4,5时在第1列九宫格左上角。。
         i / 3 || i % 3 as below:
    0  1  2  3  4  5  6  7  8
/3  0  0  0  1  1  1  2  2  2
%3  0  1  2  0  1  2  0  1  2
         从左上角开始借助i来explore该九宫格
 */

/**
 *
 * @author xinrong
 */
public class SolveSudoku {
    
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;
        solve(board);
    }
    
    private boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) return true;
                            else board[i][j] = '.'; // go back
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    // chk if valid
    private boolean isValid (char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) return false;
            if (board[row][i] == c) return false;
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i / 3] == c) return false;
        }
        return true;
    }
}
