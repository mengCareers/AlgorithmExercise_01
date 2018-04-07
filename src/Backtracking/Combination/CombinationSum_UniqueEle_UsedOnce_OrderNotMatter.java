/* 40. Combination Sum II
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
 * 
 */
package Backtracking.Combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author xinrong
 */
public class CombinationSum_UniqueEle_UsedOnce_OrderNotMatter {

    public static void main(String[] args) {
        int[] candidates = {2, 2, 2};
        List<List<Integer>> res = combinationSum2(candidates, 4);
        System.out.println(res);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> allRes = new ArrayList<>();
        Arrays.sort(candidates);
        getCombUtil(candidates, target, new ArrayList<>(), allRes, 0);
        return allRes;
    }

    private static void getCombUtil(int[] candidates, int target, List<Integer> curRes, List<List<Integer>> allRes, int starti) {
        if (target == 0) {
            allRes.add(new ArrayList<>(curRes));
        } else if (target < 0) {

        } else {
            int i = starti;
            while (i < candidates.length) {
                if (target < candidates[i]) {
                    break;
                }
                curRes.add(candidates[i]);
                getCombUtil(candidates, target - candidates[i], curRes, allRes, i + 1);
                curRes.remove(curRes.size() - 1);
                i++;
                while (i < candidates.length && i - 1 >= 0 && candidates[i] == candidates[i - 1]) {
                    i++;
                }
            }
        }
    }
}
