/*
- Tree diagrams can be used to design backtracking algo.
- The power of backtracking appears when we combine explicit and implicit constraints, 
and we stop generating nodes when these checks fail. 
We can improve the above algorithm by strengthening the constraint checks and presorting the data. 
By sorting the initial array, we need not to consider rest of the array, once the sum so far is greater than target number. 
We can backtrack and check other possibilities.
    Similarly, assume the array is presorted and we found one subset. 
We can generate next node excluding the present node only when inclusion of next node satisfies the constraints. Given below is optimized implementation (it prunes the subtree if it is not satisfying contraints).
* Objec­tive: 
Given a set of positive integers, and a value sum S, find out if there exist a subset in array whose sum is equal to given sum S.
* Thought Process:
 * 
 */
package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author xinrong
 */
public class SubsetSum {
    List<List<Integer>> subsetSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0 || candidates == null) 
            return res;
        List<Integer> curr = new ArrayList<>();
        helper(res, curr, candidates, target, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> curr, int[] candidates, int target, int start) {
        if (target < 0) 
            return;
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            curr.add(candidates[i]);
            helper(res, curr, candidates, target - candidates[i], i + 1);
            curr.remove(curr.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] candidates = {1, 2, 3};
        List<List<Integer>> res = new SubsetSum().subsetSum(candidates, 4);
        for (List<Integer> lst : res) {
            System.out.println(lst);
        }
    }
}
