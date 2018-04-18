/* 529. Minesweeper
 * Thought Process:
        // M E B X #
        // M => X,      [return
        //*E => B or #  [depending on surrounding mine

        // nothing changed
        // B => B 
        // X => X
        // # => #
 * GET:
subToClickQ helps implement Recursion if cntAdjMine is 0 :
toClickQ.addAll(subToClickQ);
The key to solution is understanding the rule of the game:
if click on ‘M’, change cell to ‘X’, return board
if click on ‘E’, check if a ‘M’ exists in adjacent cell
=> if not exists, change cell to ‘E’ and check if a ‘M’ exists in adjacent cell recursively
=> if exists, update cntAdjMine and change cell to cntAdjMine
 */
package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author xinrong
 */
public class Minesweeper {

    public char[][] updateBoard(char[][] board, int[] click) {

        Queue<int[]> toClickQ = new LinkedList<>();
        Queue<int[]> subToClickQ = new LinkedList<>();
        toClickQ.add(click);
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
        int x = 0, y = 0, nx = 0, ny = 0;
        int cntAdjMine = 0;

        while (!toClickQ.isEmpty()) {
            int[] p = toClickQ.poll();
            x = p[0];
            y = p[1];
            switch (board[x][y]) {
                case 'M':
                    board[x][y] = 'X';
                    return board;
                case 'E':
                    cntAdjMine = 0;
                    subToClickQ.clear();
                    for (int i = 0; i < 8; i++) {
                        nx = x + dir[i][0];
                        ny = y + dir[i][1];
                        // check valid of nx and ny
                        if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length) {
                            if (board[nx][ny] == 'M') {
                                cntAdjMine++;
                            }
                            if (board[nx][ny] == 'E') {
                                subToClickQ.add(new int[]{nx, ny});
                            }
                        }
                    }
                    if (cntAdjMine == 0) {
                        board[x][y] = 'B';
                        toClickQ.addAll(subToClickQ);
                    } else {
                        board[x][y] = Character.forDigit(cntAdjMine, 10);
                    }
                    break;
            }
        }
        return board;

    }
}
