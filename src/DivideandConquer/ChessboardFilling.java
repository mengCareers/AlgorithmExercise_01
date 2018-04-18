/*
盘覆盖问题：
在一个2k×2k个方格组成的棋盘中，恰有一个方格与其它方格不同，称该方格为一特殊方格，且称该棋盘为一特殊棋盘。
在棋盘覆盖问题中，要用图示的4种不同形态的L型骨牌覆盖给定的特殊棋盘上除特殊方格以外的所有方格，且任何2个L型骨牌不得重叠覆盖。
 * Thought Process:
sz = 6, hsz = 3
  r     r+hsz
  0 1 2 3 4 5
0 + + + + + +
1 + + * + + +
2 + + + + + +   (r + hsz - 1, c + hsz - 1) (r + hsz - 1. c + hsz)
3 + + + + + +   (r + hsz, c + hsz - 1)     (r + hsz, c + hsz)
4 + + + + + +
5 + + + + + +
 * 
 */
package DivideandConquer;

/**
 *
 * @author xinrong
 */
public class ChessboardFilling {

    static int ti = 1;
    static int sz = 4;
    static int[][] board = new int[sz][sz];

    public static void main(String[] args) {
        board[1][3] = 6;
        for (int[] br : board) {
            for (int b : br) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
        System.out.println("After : ");
        chessBoard(0, 0, 1, 3, sz);
        for (int[] br : board) {
            for (int b : br) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }

    static void chessBoard(int rLeftup, int cLeftup, int rSpecial, int cSpecial, int szBoard) {
        if (szBoard == 1) {
            return;
        }
        int tileId = ti++;
        // divide the chessboard
        int halfsz = szBoard / 2;
        // left-up
        if ((rSpecial < rLeftup + halfsz) && (cSpecial <= cLeftup + halfsz - 1)) {
            chessBoard(rLeftup, cLeftup, rSpecial, cSpecial, halfsz);
        } else {
            board[rLeftup + halfsz - 1][cLeftup + halfsz - 1] = tileId;
            chessBoard(rLeftup, cLeftup, rLeftup + halfsz - 1, cLeftup + halfsz - 1, halfsz);
        }
        // right-up
        if ((rSpecial < rLeftup + halfsz) && (cSpecial >= cLeftup + halfsz)) {
            chessBoard(rLeftup, cLeftup + halfsz, rSpecial, cSpecial, halfsz);
        } else {
            board[rLeftup + halfsz - 1][cLeftup + halfsz] = tileId;
            chessBoard(rLeftup, cLeftup + halfsz, rLeftup + halfsz - 1, cLeftup + halfsz, halfsz);
        }
        // left-bottom
        if ((rSpecial >= rLeftup + halfsz) && (cSpecial <= cLeftup + halfsz - 1)) {
            chessBoard(rLeftup + halfsz, cLeftup, rSpecial, cSpecial, halfsz);
        } else {
            board[rLeftup + halfsz][cLeftup + halfsz - 1] = tileId;
            chessBoard(rLeftup + halfsz, cLeftup, rLeftup + halfsz, cLeftup + halfsz - 1, halfsz);
        }
        // right-bottom
        if ((rSpecial >= rLeftup + halfsz) && (cSpecial >= cLeftup + halfsz)) {
            chessBoard(rLeftup + halfsz, cLeftup + halfsz, rSpecial, cSpecial, halfsz);
        } else {
            board[rLeftup + halfsz][cLeftup + halfsz] = tileId;
            chessBoard(rLeftup + halfsz, cLeftup + halfsz, rLeftup + halfsz, cLeftup + halfsz, halfsz);
        }
    }

}
