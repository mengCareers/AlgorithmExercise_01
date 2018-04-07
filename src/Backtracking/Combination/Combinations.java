/* 77. Combinations
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * Thought Process:
same elements in different orders counted as ONE combination
=> restrict order never-go-back
 * 
 */
package Backtracking.Combination;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> allRes = new ArrayList<>();
        getComb(new ArrayList<>(), allRes, k, 1, n);
        return allRes;
    }

    private void getComb(List<Integer> curRes, List<List<Integer>> allRes, int k, int starti, int n) {
        if (k == 0) { // MUCH BETTER THAN YOU GET SIZE OF curRes EACH TIME
            allRes.add(new ArrayList<>(curRes));
        } else {
            for (int i = starti; i <= n; i++) {
                curRes.add(i);
                getComb(curRes, allRes, k - 1, i + 1, n);
                curRes.remove(curRes.size() - 1);
            }
        }
    }
}
