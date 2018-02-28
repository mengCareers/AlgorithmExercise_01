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

    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        util(candidates, target, new ArrayList<>(), 0);
        return result;
    }
    
    void util(int[] candidates, int target, List<Integer> cur, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        if (target < 0 || start >= candidates.length)
            return;
            
        for (int i = start; i < candidates.length; i++) {
            cur.add(candidates[i]);
            util(candidates, target - candidates[i], cur, i); // if i + 1 rather than i, 223 excluded
            cur.remove(cur.size() - 1);
        }
    }
}
