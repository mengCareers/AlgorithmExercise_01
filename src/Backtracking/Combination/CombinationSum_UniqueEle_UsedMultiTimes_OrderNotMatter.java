/*
39. Combination Sum
Given a set of candidate numbers (C) (without duplicates) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.
 * Thought Process:
same elements in different order is counted as ONE combination
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
public class CombinationSum_UniqueEle_UsedMultiTimes_OrderNotMatter {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> allRes = new ArrayList<>();
        Arrays.sort(candidates);
        getCombUtil(candidates, target, new ArrayList<>(), allRes, 0);
        return allRes;
    }

    private void getCombUtil(int[] candidates, int target, List<Integer> curRes, List<List<Integer>> allRes, int starti) {
        if (target == 0) {
            allRes.add(new ArrayList<>(curRes));
        } else if (target < 0) {

        } else {
            for (int i = starti; i < candidates.length; i++) {
                if (target < candidates[i])
                    break;
                curRes.add(candidates[i]);
                getCombUtil(candidates, target - candidates[i], curRes, allRes, i);
                curRes.remove(curRes.size() - 1);
            }
        }
    }
}
