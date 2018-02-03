package Game;

/*
 *  Q:348. Design Tic-Tac-Toe
A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.
 *  Thought Process: 
To win, one must have entire row / col / dia / antidia. 
To see if have it, we only need to keep a CNT for each row / col / dia / antidia.
That is, when CNT matches sz of the board, the one won.
To see who the one is, 1 for Player1, -1 for Player2
 *  Get:
 */

/**
 *
 * @author xinrong
 */
public class DesignTicTacToe {
    private int[] rows;
    private int[] cols;
    private int dia;
    private int antidia;
    
    public DesignTicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }
    
    public int move(int row, int col, int player) {
        int n = rows.length;
        int mark = player == 1 ? 1 : -1;
        rows[row] += mark;
        cols[col] += mark;
        if (row == col) 
            dia += mark;
        // 0,2 1,1 2,0
        if (col + row == n - 1)
            antidia += mark;
        if (Math.abs(rows[row]) == n ||
            Math.abs(cols[col]) == n ||
            Math.abs(dia) == n ||
            Math.abs(antidia) == n)
            return player;
        return 0;
    }
}
