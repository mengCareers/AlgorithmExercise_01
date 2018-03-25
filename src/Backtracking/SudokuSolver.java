/* 37.Sudoku Solver
Write a program to solve a Sudoku puzzle by filling the empty cells.
Empty cells are indicated by the character '.'.
You may assume that there will be only one unique solution.
 * Thought Process:
 * 
 */
package Backtracking;

/**
 *
 * @author xinrong
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        solveSudokuUtil(board);
    }

    private boolean solveSudokuUtil(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solveSudokuUtil(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int x, int y, char c) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][y] == c) {
                return false;
            }
            if (board[x][i] == c) {
                return false;
            }
            if (board[3 * (x / 3) + i / 3][3 * (y / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }
}
