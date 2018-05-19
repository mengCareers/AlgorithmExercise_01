/* 782
input : board[][] consists of 0 and 1
output: minimum # of moves to transform the board into a 'chessboard'
0110     1010     1010
0110 --> 1010 --> 0101
1001     0101     1010
1001     0101     0101
 * Thought Process:
 * Mentor :
```
How do we check if it is possible to transform the board into the chessboard?
Only 2 kinds of rows + one should be inverse to the other, e.g., one is 0110, another one is 0110 or 1001
Assume the board N * N,
if N is even, rowOneCnt = N / 2, colOneCnt = N / 2.
if N is odd, rowOneCnt = N / 2, colOneCnt = N / 2 + 1 or rowOneCnt = N / 2 + 1, colOneCnt = N / 2
How do we count the swaps if it is possible to transform the board into the chessboard?
We count colToMove and rowToMove, (colToMove + rowToMove) / 2 will be the number of swaps in total for each swap will move either two columns or two rows.
How do we count colToMove and rowToMove?
if elements on top edge or left edge == i % 2, they need to be changed
we can change either colToMove or N - colToMove, similarly, either rowToMove or N - rowToMove
if N is even, choose the smaller one
if N is odd, we must choose the even one between ToMove or N - ToMove, for each swap will move either two columns or two rows
``` 
*/
package Searching;

/**
 *
 * @author xinrong
 */
public class TransformToChessboard {

    public int movesToChessboard(int[][] board) {
        int N = board.length, colToMove = 0, rowToMove = 0, rowOneCnt = 0, colOneCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (((board[0][0] ^ board[i][0]) ^ (board[i][j] ^ board[0][j])) == 1) {
                    return -1;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            rowOneCnt += board[0][i];
            colOneCnt += board[i][0];
            // if elements on top edge or left edge == i % 2, they need to be changed
            if (board[i][0] == i % 2) {
                rowToMove++;
            }
            if (board[0][i] == i % 2) {
                colToMove++;
            }
        }
        if (rowOneCnt < N / 2 || rowOneCnt > (N + 1) / 2) {
            return -1;
        }
        if (colOneCnt < N / 2 || colOneCnt > (N + 1) / 2) {
            return -1;
        }
        if (N % 2 == 1) {
            // we cannot make it when ..ToMove is odd
            if (colToMove % 2 == 1) {
                colToMove = N - colToMove;
            }
            if (rowToMove % 2 == 1) {
                rowToMove = N - rowToMove;
            }
        } else {
            colToMove = Math.min(colToMove, N - colToMove);
            rowToMove = Math.min(rowToMove, N - rowToMove);
        }
        return (colToMove + rowToMove) / 2;
    }
}
