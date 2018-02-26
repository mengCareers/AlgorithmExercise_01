package Backtracking;

import java.util.ArrayList;
import java.util.List;

/* 39. Combination Sum
input : candidates[] target
output: candidate[i] * n 's sum = target
 * Thought Process:
 * we reduce target gradually to save use of cursum
   if backtracking the same element, call util(i, rather than util(i + 1
 */
/**
 *
 * @author xinrong
 */
public class CombinationSum {
    
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int t = 8;
        List<List<Integer>> res = new CombinationSum().combinationSum(candidates, t);
        System.out.println(res.size());
    }

    List<List<Integer>> res;
    List<Integer> cur;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) 
            return res;
        int curptr = 0;
        res = new ArrayList<>();
        cur = new ArrayList<>();
        util(curptr, candidates, target);
        return res;
    }

    private void util(int curptr, int[] candidates, int target) {
        if (0 > target) {
            return;
        }
        if (0 == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = curptr; i < candidates.length; i++) {
            int ele = candidates[i];
            cur.add(ele);
            util(i, candidates, target - ele);
            cur.remove(cur.size() - 1);
        }
    }
}
