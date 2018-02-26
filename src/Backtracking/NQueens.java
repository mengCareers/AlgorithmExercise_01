/*
The n-queens puzzle is the problem of 
placing n queens on an n×n chessboard such that no two queens attack each other.
 * Thought Process:
 * 对角线也不行
 */
package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class NQueens {
    // m = n, n = n

    int N;
    List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        N = n;
        int[] res = new int[n];
        // res[x] = y, (x, y) put queen
        int cptr = 0;
        util(res, cptr);
        return result;
    }

    void util(int[] res, int cptr) {
        if (cptr == N) {
            printres(res);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (isValid(cptr, i, res)) {
                res[cptr] = i;
                util(res, cptr + 1);
            }
        }
    }

    void printres(int[] res) {
        List<String> curlist = new ArrayList<>();
        for (int x = 0; x < N; x++) {
            StringBuilder cur = new StringBuilder();
            for (int y = 0; y < N; y++) {
                if (y == res[x]) {
                    // is Q
                    cur.append("Q");
                } else {
                    // is .
                    cur.append(".");
                }
            }
            curlist.add(cur.toString());
        }
        result.add(curlist);
    }

    // valid if (cptr, ..) (.., y) no queen
    boolean isValid(int cptr, int i, int[] res) {
        for (int p = 0; p < cptr; p++) {
            if (res[p] == i) {
                return false;
            }
            if (res[p] - i == cptr - p)
                return false;
            if (res[p] - i == p - cptr)
                return false;
        }
        return true;
    }


}
