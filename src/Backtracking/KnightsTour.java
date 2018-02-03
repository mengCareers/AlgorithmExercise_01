package Backtracking;

/* BackTracking:tries dif solutions until one works
Qs can only be solved by trying every possible once
it is optimization over Naive & works in an incremental way
If 
    all squares are visited, print solution
Else
    we add one of nxt moves to solution, 
    recursively chk if it leads to solution
    if it not, we remove it and try other alnernative
               if none of alternatives work, return false [remove previously added (and 'no solution exists')]
    if it does, recursively add one by one until solution becomes complete
 */

/**
 *
 * @author xinrong
 */
public class KnightsTour {
    static int N = 8;
    
    static boolean solveKT() {
        int[][] sol = new int[8][8];
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                sol[x][y] = -1;
            }
        }
        int xmove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int ymove[] = {1, 2, 2, 1, -1, -2, -2, -1};
        sol[0][0] = 0;
        if (!solveKTUtil(0, 0, 1, sol, xmove, ymove)) {
            return false;
        } else { // solveKTUtil return true = movei N * N
            printSolution(sol);
        }
        return true;
    }
    
    static boolean solveKTUtil(int x, int y, int movei, int[][] sol, int[] xmove, int[] ymove) {
        int k, nxtx, nxty;
        if (movei == N * N)
            return true;
        for (k = 0; k < 8; k++) { // add 1 of 8 moves to solution and recursively chk 
            nxtx = x + xmove[k];
            nxty = y + ymove[k];
            if (isSafe(nxtx, nxty, sol)) {
                sol[nxtx][nxty] = movei;
                if (solveKTUtil(nxtx, nxty, movei + 1, sol, xmove, ymove))
                    return true;
                else
                    sol[nxtx][nxty] = -1;
            }
        }
        return false;
    }
 
    static boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < N && y >= 0 &&
                y < N && sol[x][y] == -1);
    }
 
    static void printSolution(int sol[][]) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new KnightsTour().solveKT();
    }
}
