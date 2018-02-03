/* Q: Place queens one by one in different cols, starting from leftmost, without clashes
 * Thought Process:
- start in leftmost col
- if all queens are placed, return true
- try all rows in the curr col, do following for every tried row:
    a. if queen can be placed safely in this row then mark this [row, col] as part of solution and 
       recursively chk if placing queen here leads to a solution
    b. if placing queen in [row, col] leads to a solution, then return true
    c. if placing queen doesn't lead to a solution then unmark this [row, col](backtrack) and to a. to try other rows
- if all rows have been tried and nothing worked, return false {to trigger backtracking}
 */
package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class NQueenProblem {
    public static void main(String[] args) {
        List<List<String>> ans = new NQueenProblem().solveNQ(4);
        System.out.println(ans);
    }
    
    private static List<List<String>> res;
    private static int N;
    
    public List<List<String>> solveNQ(int n) {
        N = n;
        res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        // j = cur.get(i); row i's queen put in col j
        solve(0, cur);
        return res;
    }
    
    private void solve(int r, List<Integer> cur) {
        if (r == N) {
            if (isValid(cur)) {
                List<String> curRes = buildResult(cur);
                res.add(curRes);
            }
            return;
        }
        else {
            // for child of n
            for (int i = 0; i < N; i++) {
                cur.add(i);
                if (isValid(cur)) 
                    solve(r + 1, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    private List<String> buildResult(List<Integer> cur) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < N; i++){
            String tmp = "";
            for (int j = 0; j < N; j++) {
                if (j == cur.get(i))
                    tmp += "*";
                else
                    tmp += ".";
            }
            result.add(tmp);
        }
        return result;
    }
    
    private boolean isValid(List<Integer> cur) {
        int r = cur.size() - 1;
        int c = cur.get(r);
        for (int row = 0; row < r; row++) {
            int col = cur.get(row);
            if (c == col)
                return false;
            if (r - row == c - col)
                return false;
            if (r - row == col - c)
                return false;
        }
        return true;
    }
    /*
    final int N = 4;
    
    boolean isSafe(int board[][], int row, int col) {
        int i, j;
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) return false;
        }
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }
        for (i = row, j = col; j >= 0 && i < N; i++, j--) {
            if (board[i][j] == 1) return false;
        }
        return true;
    }
    boolean solveNQUtil(int board[][], int col) {
        if (col >= N) 
            return true;
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if (solveNQUtil(board, col + 1)) 
                    return true;
                board[i][col] = 0;
            }
        }
        return false;
    }
*/
}
