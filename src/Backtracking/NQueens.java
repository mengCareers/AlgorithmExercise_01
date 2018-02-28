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

    private static int N;
    private static List<List<Integer>> interResult;

    public List<List<String>> solveNQueens(int n) {
        N = n;
        interResult = new ArrayList<>();
        util(0, new ArrayList<>());
        return constructResult(interResult);
    }

    private void util(int ri, ArrayList<Integer> cur) {
        if (ri == N) {
            interResult.add(new ArrayList<>(cur)); // !!!! cur卸货卸货～
            return;
        }
        for (int i = 0; i < N; i++) {
            if (isValid(i, ri, cur)) {
                cur.add(i);
                util(ri + 1, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }

    // true if we can cur.set(ri) = ti
    private boolean isValid(int ti, int ri, ArrayList<Integer> cur) {
        for (int i = 0; i < cur.size(); i++) {
            if (cur.get(i) == ti) {
                return false;
            }
            if (i - ri == cur.get(i) - ti) {
                return false;
            }
            if (i - ri == ti - cur.get(i)) {
                return false;
            }
        }
        return true;
    }

    private List<List<String>> constructResult(List<List<Integer>> interResult) { // [[1 3 0 2], [2 0 3 1]]
        List<List<String>> finalResult = new ArrayList<>();
        for (List<Integer> res : interResult) {
            List<String> solu = new ArrayList<>();
            for (int r : res) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    if (i == r) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                solu.add(sb.toString());
            }
            finalResult.add(solu);
        }
        return finalResult;
    }

}
